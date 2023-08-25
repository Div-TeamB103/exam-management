package com.exammanagament.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
    @JoinColumn(name = "exam_type_id")
    private ExamType examType;

    @ManyToMany(fetch = FetchType.LAZY)//lazy for now
    @JoinTable(name = "exam_student",
            joinColumns = @JoinColumn(name = "exam_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")

    )
    private List<User> userList;


    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private Set<ExamQuestion> examQuestions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private Set<ExamStudent> examStudents = new LinkedHashSet<>();

    @Column
    @ManyToOne
    @JoinColumn(name = "admin_id" , referencedColumnName = "id")
    private User user ;



    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", startDate=" + startDate +

                ", examType=" + examType +
                ", examQuestions=" + examQuestions +
                ", examStudents=" + examStudents +
                '}';
    }
}