package com.exammanagament.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ExamStudentDto {
    private Long id;
    private Long student_id;
    private Long exam_id;
    private Integer point;

}