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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "join_date")
    private Instant joinDate;

    @Column(name = "birth_date")
    private Instant birthDate;

    @Column(name = "phone_number", length = 30)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Column(name = "status")
    private Byte status;

    @Column(name = "last_login_date")
    private Instant lastLoginDate;

    @Column(name = "last_login_ip", length = 30)
    private String lastLoginIp;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "surname", length = 50)
    private String surname;

    @OneToMany(mappedBy = "student")
    private Set<ExamStudent> examStudents = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(email, student.email) && Objects.equals(password, student.password) && Objects.equals(joinDate, student.joinDate) && Objects.equals(birthDate, student.birthDate) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(parent, student.parent) && Objects.equals(status, student.status) && Objects.equals(lastLoginDate, student.lastLoginDate) && Objects.equals(lastLoginIp, student.lastLoginIp) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(examStudents, student.examStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, joinDate, birthDate, phoneNumber, parent, status, lastLoginDate, lastLoginIp, name, surname, examStudents);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", joinDate=" + joinDate +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", parent=" + parent +
                ", status=" + status +
                ", lastLoginDate=" + lastLoginDate +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", examStudents=" + examStudents +
                '}';
    }
}