package com.exammanagament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "question_name")
    private String questionName;

    @OneToMany(mappedBy = "question")
    private Set<ExamQuestion> examQuestions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(questionName, question.questionName) && Objects.equals(examQuestions, question.examQuestions) && Objects.equals(answers, question.answers);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, questionName, examQuestions, answers);

    }
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionName='" + questionName + '\'' +
                ", examQuestions=" + examQuestions +
                ", answers=" + answers +
                '}';
    }
}