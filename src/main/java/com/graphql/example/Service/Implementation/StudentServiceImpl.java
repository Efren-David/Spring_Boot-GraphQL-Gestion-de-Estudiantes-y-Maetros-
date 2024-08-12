package com.graphql.example.Service.Implementation;

import com.graphql.example.Service.IStudentService;
import com.graphql.example.entity.Student;
import com.graphql.example.persistence.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImpl implements IStudentService {


    @Autowired
    private IStudentDao studentDao;


    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) studentDao.findAll();
    }

    @Override
    @Transactional
    public void createStudent(Student student) {
        studentDao.save(student);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }
}
