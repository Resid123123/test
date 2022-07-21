package com.test.api;

import com.test.entity.TeacherEntity;
import com.test.request.CreateTeacherRequest;
import com.test.response.GetStudentResponse;
import com.test.response.GetTeacherResponse;
import com.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherApi {

    @Autowired
    private TeacherService teacherService;


    @GetMapping("/all")
    public List<GetTeacherResponse> getAllTeacher() {
        return teacherService.getAllTeacher();
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