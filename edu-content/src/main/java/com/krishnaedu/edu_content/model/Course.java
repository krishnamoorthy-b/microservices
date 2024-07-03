package com.krishnaedu.edu_content.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Course {
    private String id;
    private String name;
    private List<Technology> technologies;
}
