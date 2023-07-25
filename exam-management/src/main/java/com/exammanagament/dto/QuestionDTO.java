package com.exammanagament.dto;



import lombok.*;

import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuestionDTO {
    private String questionName;
    private Set<Long> examQuestionIds;
    private Set<Long> answerIds;

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "questionName='" + questionName + '\'' +
                ", examQuestionIds=" + examQuestionIds +
                ", answerIds=" + answerIds +
                '}';
    }
}

