package com.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "teacher")
    private List<StudentEntity> students;

    @ManyToMany
    private List<SubjectEntity> subjects;

    @OneToMany(mappedBy = "teacher")
    List<TeacherCourseEntity> teachers;

}