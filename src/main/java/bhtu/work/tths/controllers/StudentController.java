package bhtu.work.tths.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhtu.work.tths.models.Student;
import bhtu.work.tths.models.dto.StudentOneReward;
import bhtu.work.tths.services.StudentService;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // #region mapping
    @GetMapping("get")
    public Student getStudent(@RequestParam(name = "id") @NonNull String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("find")
    public List<Student> findStudent(@RequestParam(name = "category", defaultValue = "ID") String categoryStr,
            @RequestParam(name = "filter") String filter) {

        return studentService.findStudent(categoryStr, filter);

    }

    @PostMapping("add")
    public boolean addStudent(@RequestBody Student idlessHocSinh) {
        studentService.addStudent(idlessHocSinh);
        return true;
    }

    @PutMapping("change")
    public boolean changeStudent(@RequestBody StudentOneReward changedStudent) {
        studentService.changeStudent(changedStudent);
        return true;
    }

    // #endregion
}
