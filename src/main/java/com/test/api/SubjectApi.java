package com.test.api;

import com.test.request.CreateStudentRequest;
import com.test.request.CreateSubjectRequest;
import com.test.response.GetCourseResponse;
import com.test.response.GetStudentResponse;
import com.test.response.GetSubjectResponse;
import com.test.response.SearchSubjectResponse;
import com.test.service.StudentService;
import com.test.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectApi {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/search")
    public SearchSubjectResponse getAllSubject(
            @RequestParam(value = "page",required = false,defaultValue = "0") int page,
            @RequestParam(value = "size",required = false,defaultValue = "3") int size) {
        return subjectService.getAllSubject(page, size);
    }

//    @GetMapping("/{id}")
//    public GetSubjectResponse getSubjectById(
//            @PathVariable("id") Long id
//    ) {
//        return subjectService.getSubjectById(id);
//    }

    @PostMapping("/create")
    public GetSubjectResponse createSubject(
            @RequestBody CreateSubjectRequest request
    ) {
        return subjectService.createSubject(request);
    }


    @PutMapping("/update/{id}")
    public GetSubjectResponse createSubject(
            @RequestBody CreateSubjectRequest request,
            @PathVariable Long id
    ) {
        return subjectService.updateSubject(request, id);
    }
}
