package com.exammanagament.dto;

import lombok.*;

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

}
