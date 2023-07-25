package com.exammanagament.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ExamAdminDto {
    private String username;

    @Override
    public String toString() {
        return "ExamAdminDto{" +
                "username='" + username + '\'' +
                '}';
    }
}
