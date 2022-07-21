package com.test.service;

import com.test.entity.CourseEntity;
import com.test.entity.StudentEntity;
import com.test.entity.TeacherCourseEntity;
import com.test.entity.TeacherEntity;
import com.test.mapper.ObjectMapper;
import com.test.repository.CourseRepository;
import com.test.repository.StudentRepository;
import com.test.repository.TeacherCourseRepository;
import com.test.repository.TeacherRepository;
import com.test.request.CreateCourseRequest;
import com.test.request.CreateStudentRequest;
import com.test.response.GetCourseResponse;
import com.test.response.GetStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherCourseRepository teacherCourseRepository;

    @Autowired
    private TeacherRepository teacherRepository;


    @Autowired
    private ObjectMapper objectMapper;

    public List<GetCourseResponse> getAllCourse() {
        return courseRepository.findAll().stream()
                .map(objectMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public GetCourseResponse getCourseById(Long id) {
        return objectMapper.entityToDto(courseRepository.getById(id));
    }

    public GetCourseResponse createCourse(CreateCourseRequest request) {
        CourseEntity entity = objectMapper.dtoToEntity(request);
        return objectMapper.entityToDto(courseRepository.save(entity));
    }



    public GetCourseResponse updateCourse(CreateCourseRequest request, Long id) {
        CourseEntity entity =
                courseRepository.findById(id).orElseThrow(NullPointerException::new);

        entity.setName(request.getName());

        return objectMapper.entityToDto(courseRepository.save(entity));
    }
}
