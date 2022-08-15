package com.test.repository.mysql;

import com.test.entity.TeacherCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourseEntity,Long> {
}
