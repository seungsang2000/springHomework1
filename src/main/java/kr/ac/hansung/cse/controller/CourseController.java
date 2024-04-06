package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.model.SemesterGrade;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String showCourses(Model model) {
        List<Course> Courses = courseService.getDetailsCourse(2024, 1);
        model.addAttribute("id_courses", Courses);
        return "courses";
    }

@GetMapping("/createcourse")
    public String createCourse(Model model) {
        model.addAttribute("course", new Course());
        return "createcourse";
    }

    @PostMapping("/docreate")
    public String doCreate(Model model, @Valid Course course, BindingResult result) {
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "createcourse";
        }
        courseService.insert(course);
        return "coursecreated";
    }

    @GetMapping("/semestergrades")
    public String showSemesterGrade(Model model) {
        List<SemesterGrade> semesterGrades = courseService.getSemesterGrades();
        model.addAttribute("id_semesterGrades", semesterGrades);
        return "semestergrades";
    }

    @GetMapping("/semestergrades/Details")
    public String showSemesterGradeDetails(@RequestParam("year") int year, @RequestParam("semester") int semester, Model model) {
        List<Course> semesterGradesDetails = courseService.getDetailsCourse(year, semester);

        model.addAttribute("id_semesterGradesDetails", semesterGradesDetails);

        return "semesterGradeDetails";
    }
}
