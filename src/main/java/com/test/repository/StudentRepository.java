package com.test.repository;

import com.test.entity.StudentEntity;
import com.test.repository.view.StudentListView;
import com.test.response.SearchStudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, Long> {

    Page<StudentListView> findBy(Class<StudentListView> type, Pageable pageable, Specification<StudentEntity> studentSpecification);

    StudentListView findById(Long id, Class<StudentListView> type);

    @Query(nativeQuery = true, value = "SELECT * FROM STUDENT WHERE name= :newName")
    StudentEntity updateStudentName(String newName);

    @Query(value = "SELECT t FROM StudentEntity t WHERE t.name= :newName")
    StudentEntity test(@Param("newName") String newName);

    Page<StudentEntity> findAll(Specification<StudentEntity> studentSpecification, Pageable of);
}


// Projection +

// Criteria
// security
// Exception


// Cacheing
// JDBC
// scheule
// batch
