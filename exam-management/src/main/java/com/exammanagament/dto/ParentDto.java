package com.exammanagament.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ParentDto{
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private List<Long> studentsId;

}
