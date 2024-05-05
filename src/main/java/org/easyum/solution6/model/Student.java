package org.easyum.solution6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_name")
    private String name;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Avatar avatar;
    //private List<EMail> emails;
    //private List<Course> courses;
}
