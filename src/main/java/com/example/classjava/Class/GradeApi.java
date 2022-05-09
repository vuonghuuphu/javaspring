package com.example.classjava.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/grades")
public class GradeApi {

    @Autowired
    GradeService gradeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Grade>> getlist() {
        return ResponseEntity.ok(gradeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Grade> save(@RequestBody Grade p) {
        return ResponseEntity.ok(gradeService.save(p));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> detail(@PathVariable int id) {
        Optional<Grade> optionalStudent = gradeService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalStudent.get());
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Grade> update(@PathVariable int id, @RequestBody Student p) {
        Optional<Grade> optionalStudent = gradeService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Grade found = optionalStudent.get();
        if (found != null) {
            found.setName(p.getRollNumber());
            found.setStudentGrades(p.getStudentGrades());
        }
        return ResponseEntity.ok(gradeService.save(found));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!gradeService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        gradeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
