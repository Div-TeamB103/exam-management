package com.exammanagament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exam_admin")
public class ExamAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", length = 80)
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "admin")
    private Set<Exam> exams = new LinkedHashSet<>();

   }