package com.exammanagament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "exam_name", length = 100)
    private String examName;

    @Column(name = "start_date")
    private Instant startDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id")
    private ExamAdmin admin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_type_id")
    private ExamType examType;

    @OneToMany(mappedBy = "exam")
    private Set<ExamQuestion> examQuestions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "exam")
    private Set<ExamStudent> examStudents = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return Objects.equals(id, exam.id) && Objects.equals(examName, exam.examName) && Objects.equals(startDate, exam.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, examName, startDate);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", startDate=" + startDate +
                ", admin=" + admin +
                ", examType=" + examType +
                ", examQuestions=" + examQuestions +
                ", examStudents=" + examStudents +
                '}';
    }
}