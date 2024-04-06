package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDao {
    private JdbcTemplate jdbcTemplate;  // psa(portable service abstraction, sql(x) api

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Course> getCourses() {
        String sqlStatement= "select * from courses";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                Course course= new Course();

                course.setCode(rs.getString("code"));
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setSubjectName(rs.getString("subjectName"));
                course.setSubjectClassification(rs.getString("subjectClassification"));
                course.setProfessor(rs.getString("professor"));
                course.setGrade(rs.getInt("grade"));

                return course;
            }
        });
    }
    public boolean insertCourse(Course course) {

        String code = course.getCode();
        int year = course.getYear();
        int semester = course.getSemester();
        String subjectName = course.getSubjectName();
        String subjectClassification = course.getSubjectClassification();
        String professor = course.getProfessor();
        int grade = course.getGrade();

        String sqlStatement= "insert into courses (code, year, semester, subjectName, subjectClassification, professor, grade) values (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {code, year, semester, subjectName, subjectClassification, professor, grade}) == 1);
    }


}
