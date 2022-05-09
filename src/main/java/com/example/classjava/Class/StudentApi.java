package com.example.classjava.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentApi {

    @Autowired
    StudentService studentService;
    @Autowired
    GradeService gradeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getlist() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student p) {
        return ResponseEntity.ok(studentService.save(p));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> detail(@PathVariable String id) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalStudent.get());
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Student> update(@PathVariable String id, @RequestBody Student p) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Student found = optionalStudent.get();
        if (found != null) {
            found.setRollNumber(p.getRollNumber());
            found.setFullname(p.getFullname());
            found.setStudentGrades(p.getStudentGrades());
        }
        return ResponseEntity.ok(studentService.save(found));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!studentService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/addgrade")
    public ResponseEntity<?> addstdToclass(
            @RequestParam String studentrollnumber,
            @RequestParam int gradeid
    ) {
        Optional<Student> optionalStudent = studentService.findById(studentrollnumber);
        Optional<Grade> optionalGrade = gradeService.findById(gradeid);
        System.out.println(optionalStudent);
        if (!optionalStudent.isPresent() || !optionalGrade.isPresent()){
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        boolean result = studentService.AddStudentToClass(optionalStudent.get(),optionalGrade.get());
        if (!result){
            return new ResponseEntity<>("add student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("add student success", HttpStatus.OK);
    }
}
