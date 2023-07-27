package com.exammanagament.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private Long id;
    private String option;
    private boolean isCorrect;


}
