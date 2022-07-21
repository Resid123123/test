
package com.test.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTeacherCourseRequest {
    private  CreateTeacherRequest teacher;
    private CreateCourseRequest course;
    private LocalDateTime dateTime;
}
