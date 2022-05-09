package com.example.classjava.Category;

import com.example.classjava.Class.Grade;
import com.example.classjava.Class.GradeService;
import com.example.classjava.Class.Student;
import com.example.classjava.Class.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoriesApi {

    @Autowired
    CategoriesService categoriesService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getlist() {
        return ResponseEntity.ok(categoriesService.findAll());
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category p) {
        return ResponseEntity.ok(categoriesService.save(p));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> detail(@PathVariable int id) {
        Optional<Category> optional = categoriesService.findById(id);
        if (!optional.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!categoriesService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        categoriesService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
