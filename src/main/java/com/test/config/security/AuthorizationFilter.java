package com.test.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.entity.TokenEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.test.config.security.SecurityUtil.pathIsWhiteListed;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter{

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            if (pathIsWhiteListed(request.getContextPath())) {
                filterChain.doFilter(request, response);
            } else {
                final String authorizationHeader = request.getHeader(AUTHORIZATION);
                if (Objects.nonNull(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
                    TokenEntity token = jwtUtil.verifyToken(authorizationHeader);
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    token.getUsername(), null, List.of((GrantedAuthority) () -> "ADMIN")
                             );
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
                filterChain.doFilter(request, response);
            }
        } catch (RuntimeException ex) {
            response.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(
                    response.getOutputStream(),
                    "ERROR"
            );
        }
    }
}
