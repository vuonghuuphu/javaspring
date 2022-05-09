package com.example.classjava.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(String id) {studentRepository.deleteById(id); }

    public boolean AddStudentToClass(Student student,Grade grade){
        try {
            Set<StudentGrade> studentGrades = student.getStudentGrades();
            if (studentGrades == null){
                studentGrades = new HashSet<>();
            }
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setId(new StudentGradeId(grade.getId(),student.getRollNumber()));
            studentGrade.setGrade(grade);
            studentGrade.setStudent(student);
            studentGrades.add(studentGrade);
            student.setStudentGrades(studentGrades);
            studentRepository.save(student);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}

