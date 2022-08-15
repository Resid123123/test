package com.test.response.searchQuery;

import com.test.entity.StudentEntity;
import com.test.request.SearchStudentRequest;
import com.test.specification.StudentSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public interface SearchQueries {

    static Specification<StudentEntity> createStudentSpecification(SearchStudentRequest request){
        return new StudentSpecification(request);
    }


}
