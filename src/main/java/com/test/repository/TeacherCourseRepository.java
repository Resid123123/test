package com.test.repository;

import com.test.entity.TeacherCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourseEntity,Long> {
}
