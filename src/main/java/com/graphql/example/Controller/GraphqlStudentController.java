package com.graphql.example.Controller;


import com.graphql.example.Service.ICourseService;
import com.graphql.example.Service.IStudentService;
import com.graphql.example.entity.Course;
import com.graphql.example.entity.Student;
import com.graphql.example.graphql.InputStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphqlStudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id){
        Long studentId = Long.parseLong(id);

        return  studentService.findById(studentId);
    }


    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll(){

        return studentService.findAll();
    }


    @MutationMapping
    public Student createStudent(@Argument InputStudent inputStudent){


        Course course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));

        Student student = new Student();
        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);

        studentService.createStudent(student);

        return student;
    }

    @MutationMapping(name = "deleteStudentById")
    public String deleteById(@Argument(name = "studentId") String id){
        studentService.deleteById(Long.parseLong(id));

        return "El estudiamte con id " + id + " ha sido eliminado.";
    }
}
