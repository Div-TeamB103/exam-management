package com.exammanagament.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "answer_option")
    private String option;

    @ManyToOne(fetch = FetchType.EAGER  )
    @JoinColumn(name = "question_id" )

    private Question question;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(option, answer.option) &&
                Objects.equals(question, answer.question) && Objects.equals(isCorrect, answer.isCorrect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, option, question, isCorrect);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", option='" + option + '\'' +
                ", question=" + question +
                ", isCorrect=" + isCorrect +
                '}';
    }
}