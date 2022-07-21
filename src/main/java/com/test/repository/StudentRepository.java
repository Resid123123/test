package com.test.repository;

import com.test.entity.StudentEntity;
import com.test.repository.view.StudentListView;
import com.test.repository.view.StudentListView2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, Long> {
// findAllProjectedBy
// findBy
//    --
// findById  Class<Projection>

//    List<StudentEntity> findAll(Pageable pageable);

    //List<StudentListView> findBy(Class<StudentListView> type);
    List<StudentListView> findBy(Class<StudentListView> type);

    List<StudentListView2> findAnoBy(Class<StudentListView2> type);

    StudentListView findById(Long id, Class<StudentListView> type);

    StudentListView2 findAnoById(Long id, Class<StudentListView2> type);

    @Query(nativeQuery = true, value = "SELECT * FROM STUDENT WHERE name= :newName")
    StudentEntity updateStudentName(String newName);

    @Query(value = "SELECT t FROM StudentEntity t WHERE t.name= :newName")
    StudentEntity test(@Param("newName") String newName);


//    @Query("select u from User u where u.firstname = :#{#customer.firstname}")
//    List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);
}


// Projection +

// Criteria
// Cacheing
// JDBC
// security
