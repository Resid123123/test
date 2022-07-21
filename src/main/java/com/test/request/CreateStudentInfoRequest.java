package com.test.request;

import lombok.Data;

@Data
public class CreateStudentInfoRequest {

    private Long id;
    private String email;
    private String address;

    @Override
    public String toString() {
        return "CreateStudentInfoRequest{" +
                "email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
