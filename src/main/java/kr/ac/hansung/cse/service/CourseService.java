package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseDao;
import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.model.SemesterGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getAllCourses() {
        return courseDao.getCourses();
    }

    public void insert(Course course) {
        courseDao.insertCourse(course);
    }

    public List<SemesterGrade> getSemesterGrades() {
        return courseDao.getSemesterGrades();
    }

    public List<Course> getDetailsCourse(int year, int semester) {
        return courseDao.getDetailsCourse(year, semester);
    }
}
