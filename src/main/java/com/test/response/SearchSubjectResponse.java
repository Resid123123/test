package com.test.response;

import com.test.repository.view.StudentListView;
import lombok.Data;

import java.util.List;

@Data
public class SearchSubjectResponse {
    private Integer totalPages;
    private Long totalElements;
    private List<GetSubjectResponse> subjectList;
}
