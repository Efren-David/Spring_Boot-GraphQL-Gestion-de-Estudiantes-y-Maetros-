package com.graphql.example.graphql;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class InputStudent {

    private Long id;

    private String name;

    private String lastName;

    private Integer age;

    private String courseId;
}
