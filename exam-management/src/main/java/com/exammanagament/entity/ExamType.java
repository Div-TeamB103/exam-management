package com.exammanagament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "exam_type")
public class ExamType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "examType")
    private Set<Exam> exams = new LinkedHashSet<>();


    public ExamType(Long id, String type, String description, Set<Exam> exams) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "ExamType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", exams=" + exams +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamType examType = (ExamType) o;
        return Objects.equals(id, examType.id) && Objects.equals(type, examType.type) && Objects.equals(description, examType.description) && Objects.equals(exams, examType.exams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, description, exams);
    }
}

