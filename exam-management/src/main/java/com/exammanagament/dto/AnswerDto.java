package com.exammanagament.dto;

import com.exammanagament.entity.Question;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private String option;
    private boolean isCorrect;
    private QuestionDTO question;





}
