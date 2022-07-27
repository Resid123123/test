package com.test.api;

import com.test.JDBC1.JdbcTest;
import com.test.JDBC1.teacher;
import com.test.entity.TeacherEntity;
import com.test.request.CreateTeacherRequest;
import com.test.response.GetStudentResponse;
import com.test.response.GetTeacherResponse;
import com.test.service.StudentService;
import com.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherApi {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private JdbcTest jdbcTest;

    @GetMapping("/all")
    public List<GetTeacherResponse> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @GetMapping("/all1")
    public List<teacher> getAllTeacher1() throws SQLException {

        return jdbcTest.jdbc11();
    }

    @GetMapping("/{id}")
    public GetTeacherResponse getTeacherById(
            @PathVariable("id") Long id
    ) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/create")
    public GetTeacherResponse createTeacher(
            @RequestBody CreateTeacherRequest request
    ) {
        return teacherService.createTeacher(request);
    }

    @PutMapping("/update/{id}")
    public GetTeacherResponse createTeacher(
            @RequestBody CreateTeacherRequest request,
            @PathVariable Long id
    ) {
        return teacherService.updateTeacher(request, id);
    }


}