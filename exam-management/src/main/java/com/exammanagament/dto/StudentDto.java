package com.exammanagament.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String email;
    private LocalDateTime birth_date;
    private String phone_number;
    private String status;
    private String name;
    private String surname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return Objects.equals(email, that.email) && Objects.equals(birth_date, that.birth_date) && Objects.equals(phone_number, that.phone_number) && Objects.equals(status, that.status) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, birth_date, phone_number, status, name, surname);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "email='" + email + '\'' +
                ", birth_date=" + birth_date +
                ", phone_number='" + phone_number + '\'' +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}


