package com.graphql.example.persistence;

import com.graphql.example.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentDao extends CrudRepository<Student, Long> {
}
