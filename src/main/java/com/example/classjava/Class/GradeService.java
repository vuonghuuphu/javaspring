package com.example.classjava.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeService;

    public List<Grade> findAll() {
        return gradeService.findAll();
    }

    public Optional<Grade> findById(int id) {
        return gradeService.findById(id);
    }

    public Grade save(Grade grade) {
        return gradeService.save(grade);
    }

    public void deleteById(int id) {gradeService.deleteById(id); }
}
