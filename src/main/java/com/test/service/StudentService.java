package com.test.service;

import com.test.entity.StudentEntity;
import com.test.mapper.ObjectMapper;
import com.test.repository.StudentRepository;
import com.test.repository.view.StudentListView;
import com.test.repository.view.StudentListView2;
import com.test.request.CreateStudentRequest;
import com.test.response.GetOneStudentViewResponse;
import com.test.response.GetStudentResponse;
import com.test.response.SearchStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public SearchStudentResponse getAllStudent(int page, int size) {
        SearchStudentResponse response = new SearchStudentResponse();

        Page<StudentEntity> studentEntityPage = studentRepository
                .findAll(PageRequest.of(page, size,Sort.by("id").descending()));

        response.setStudentList(
                studentEntityPage.getContent().stream()
                        .map(objectMapper::entityToDto)
                        .collect(Collectors.toList())
        );
        response.setTotalPages(studentEntityPage.getTotalPages());
        response.setTotalElements(studentEntityPage.getTotalElements());

        return response;
    }

//      studentEntityPage.getContent().stream()
//                        .map(objectMapper::entityToDto)
//                        .collect(Collectors.toList())

    public GetOneStudentViewResponse getStudentById(Long id) {
        //studentRepository.findBy(StudentListView.class);
        // studentRepository.findAnoBy(StudentListView2.class);
        //studentRepository.findById(id, StudentListView.class);
        //  studentRepository.findAnoById(id,StudentListView2.class);
//        StudentEntity entity = studentRepository.findById(id).orElseThrow(NullPointerException::new);
//        return objectMapper.entityToDto(entity);

        return objectMapper.entityToDto(studentRepository.findById(id, StudentListView.class));   // map  etmek?????
    }

    public GetStudentResponse createStudent(CreateStudentRequest request) {
        StudentEntity entity = objectMapper.dtoToEntity(request);
        return objectMapper.entityToDto(studentRepository.save(entity));
    }

    public GetStudentResponse updateStudent(CreateStudentRequest request, Long id) {
        StudentEntity entity =
                studentRepository.findById(id).orElseThrow(NullPointerException::new);

        StudentEntity updatedEntity = studentRepository.save(objectMapper.updateEntity(request, entity));

        return objectMapper.entityToDto(updatedEntity);
    }

}
