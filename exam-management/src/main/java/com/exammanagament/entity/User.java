package com.exammanagament.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 30)
    private String name;

    @Column(name = "surname",length = 50)
    private String surname;

    @Column(name = "email",length = 50,unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number",length = 30)
    private String phoneNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    @Column(name = "last_login_ip",length = 30)
    private String lastLoginIp;

    @Column(name = "status")
    private Boolean status;

}
