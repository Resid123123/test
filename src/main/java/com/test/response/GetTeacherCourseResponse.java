package com.test.response;

import com.test.request.CreateCourseRequest;
import com.test.request.CreateTeacherRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetTeacherCourseResponse {

    private  Long id;
    private CreateTeacherRequest teacher;
    private CreateCourseRequest course;
    private LocalDateTime dateTime;
}
