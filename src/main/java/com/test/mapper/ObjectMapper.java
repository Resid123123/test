package com.test.mapper;

import com.test.entity.*;
import com.test.repository.SubjectRepository;
import com.test.repository.view.StudentListView;
import com.test.request.CreateCourseRequest;
import com.test.request.CreateStudentRequest;
import com.test.request.CreateSubjectRequest;
import com.test.request.CreateTeacherCourseRequest;
import com.test.response.*;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class ObjectMapper {

    public abstract GetStudentResponse entityToDto(StudentEntity entity);

    public abstract GetTeacherResponse entityToDto(TeacherEntity entity);

    public abstract GetSubjectResponse entityToDto(SubjectEntity entity);

    public abstract SubjectEntity dtoToEntity(CreateSubjectRequest request);

    public abstract StudentEntity dtoToEntity(CreateStudentRequest request);


    public abstract CourseEntity dtoToEntity(CreateCourseRequest request);

    public abstract GetCourseResponse entityToDto(CourseEntity entity);

    public abstract GetOneStudentViewResponse entityToDto(StudentListView entity);
    public abstract GetOneStudentViewResponse entityToDto2(StudentListView entity);

    public abstract TeacherCourseEntity dtoToEntity(CreateTeacherCourseRequest request);

    public abstract GetTeacherCourseResponse entityToDto(TeacherCourseEntity entity);

    public StudentEntity updateEntity(CreateStudentRequest request, StudentEntity entity) {
        entity.setName(request.getName());
        entity.setSurname(request.getSurname());
        StudentInfoEntity studentInfoEntity = new StudentInfoEntity();
        studentInfoEntity.setId(request.getStudentInfo().getId());
        studentInfoEntity.setAddress(request.getStudentInfo().getAddress());
        studentInfoEntity.setEmail(request.getStudentInfo().getEmail());
        entity.setStudentInfo(studentInfoEntity);
        return entity;
    }


}
