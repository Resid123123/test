package com.test.service;

import com.test.entity.StudentEntity;
import com.test.exception.CustomUserNotFoundException;
import com.test.mapper.ObjectMapper;
import com.test.repository.mysql.StudentRepository;
import com.test.repository.mysql.view.StudentListView;
import com.test.request.CreateStudentRequest;
import com.test.request.SearchStudentRequest;
import com.test.response.GetOneStudentViewResponse;
import com.test.response.GetStudentResponse;
import com.test.response.SearchStudentResponse;
import com.test.response.searchQuery.SearchQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public SearchStudentResponse getAllStudent(SearchStudentRequest request, int page, int size) {
        SearchStudentResponse response = new SearchStudentResponse();

        Page<StudentEntity> studentEntityPage = studentRepository
                .findAll(
                        SearchQueries.createStudentSpecification(request) ,
                        PageRequest.of(page, size)
                );

        response.setStudentList(
                studentEntityPage.getContent().stream()
                        .map(objectMapper::entityToDto)
                        .collect(Collectors.toList())
        );
        response.setTotalPages(studentEntityPage.getTotalPages());
        response.setTotalElements(studentEntityPage.getTotalElements());

        return response;
    }

    public GetOneStudentViewResponse getStudentById(Long id) {
     return objectMapper.entityToDto(studentRepository.findById(id, StudentListView.class));
    }

    public GetStudentResponse createStudent(CreateStudentRequest request){
        StudentEntity entity = objectMapper.dtoToEntity(request);
        if (6!=4){
            throw new CustomUserNotFoundException("asdfasdfas");
        }
        return objectMapper.entityToDto(studentRepository.save(entity));
    }

    public GetStudentResponse updateStudent(CreateStudentRequest request, Long id) {
        StudentEntity entity =
                studentRepository.findById(id).orElseThrow(NullPointerException::new);

        StudentEntity updatedEntity = studentRepository.save(objectMapper.updateEntity(request, entity));

        return objectMapper.entityToDto(updatedEntity);
    }

}
