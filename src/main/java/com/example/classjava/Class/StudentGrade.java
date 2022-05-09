package com.example.classjava.Class;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students_grades")
public class StudentGrade {
    @EmbeddedId
    private StudentGradeId Id;
    @ManyToOne
    @MapsId("gradeId")
    @JoinColumn(name = "grade_id")
    private Grade grade;
    @ManyToOne
    @MapsId("studentRollNumber")
    @JoinColumn(name = "student_rollnumber")
    private Student student;


}
