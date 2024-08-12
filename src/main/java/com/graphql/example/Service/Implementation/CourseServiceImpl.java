package com.graphql.example.Service.Implementation;

import com.graphql.example.Service.ICourseService;
import com.graphql.example.entity.Course;
import com.graphql.example.persistence.ICourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CourseServiceImpl implements ICourseService {


    @Autowired
    private ICourseDao courseDao;

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) courseDao.findAll();
    }


    @Override
    @Transactional
    public void createCourse(Course course) {
        courseDao.save(course);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        courseDao.deleteById(id);

    }
}
