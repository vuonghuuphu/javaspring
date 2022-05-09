package com.example.classjava.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    private String rollNumber;
    private String fullname;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<StudentGrade> studentGrades;
}
