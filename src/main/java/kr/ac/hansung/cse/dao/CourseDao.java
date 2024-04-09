package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.model.SemesterGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<SemesterGrade> getSemesterGrades() {
        String sqlStatement = "select year, semester, sum(grade) as total_grade from courses group by year, semester order by year, semester";
        return jdbcTemplate.query(sqlStatement, new ResultSetExtractor<List<SemesterGrade>>() {
            @Override
            public List<SemesterGrade> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<SemesterGrade> listRet= new ArrayList<SemesterGrade>();
                while(rs.next()){
                    SemesterGrade semesterGrade = new SemesterGrade();
                    semesterGrade.setYear(rs.getInt("year"));
                    semesterGrade.setSemester(rs.getInt("semester"));
                    semesterGrade.setTotalGrade(rs.getInt("total_grade"));
                    listRet.add(semesterGrade);
                }
                return listRet;
            }
        });
    }


    public List<Course> getDetailsCourse(int year, int semester) {
        String sqlStatement = "select * from courses where year = ? and semester = ?";
        return jdbcTemplate.query(sqlStatement, new Object[]{year, semester}, (rs, rowNum) -> {
            Course course = new Course();
            course.setYear(rs.getInt("year"));
            course.setSemester(rs.getInt("semester"));
            course.setCode(rs.getString("code"));
            course.setSubjectName(rs.getString("subjectName"));
            course.setSubjectClassification(rs.getString("subjectClassification"));
            course.setProfessor(rs.getString("professor"));
            course.setGrade(rs.getInt("grade"));
            return course;
        });
    }
}
