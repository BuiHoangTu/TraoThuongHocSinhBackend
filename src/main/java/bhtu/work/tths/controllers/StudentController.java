package bhtu.work.tths.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.Student;
import bhtu.work.tths.models.enums.EGetStudents;
import bhtu.work.tths.services.StudentService;

@RestController
@RequestMapping(path = "student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("get")
    public Student getStudent(@RequestParam(name = "id", required = true) @NonNull String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("find")
    public List<Student> findStudent(@RequestParam(name = "category", defaultValue = "ID") String categoryStr,
            @RequestParam(name = "filter") String filter) {

        EGetStudents category = EGetStudents.valueOf(categoryStr.toUpperCase());
        return studentService.findStudent(category, filter);

    }

    @PostMapping("add")
    public void addStudent(@RequestBody Student idlessHocSinh) {
        studentService.addStudent(idlessHocSinh);
    }
}
