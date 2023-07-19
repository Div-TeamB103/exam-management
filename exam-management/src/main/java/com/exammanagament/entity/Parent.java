package com.exammanagament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "surname", length = 30)
    private String surname;

    @Column(name = "email", length = 80)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number", length = 30)
    private String phoneNumber;

    @Column(name = "last_login_date")
    private Instant lastLoginDate;

    @Column(name = "status")
    private Byte status;

    @Column(name = "last_login_ip", length = 30)
    private String lastLoginIp;

    @OneToMany(mappedBy = "parent")
    private Set<Student> students = new LinkedHashSet<>();

    }