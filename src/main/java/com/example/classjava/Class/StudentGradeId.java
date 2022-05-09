package com.example.classjava.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class StudentGradeId implements Serializable {
    @Column(name = "grade_id")
    private int gradeId;
    @Column(name = "student_rollnumber")
    private String studentRollnumber;
}
