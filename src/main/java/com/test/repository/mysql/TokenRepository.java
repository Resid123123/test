package com.test.repository.mysql;

import antlr.Token;
import com.test.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<TokenEntity,Long> {
    Optional<TokenEntity> findByToken(String token);

    void deleteByToken(String token);
}
