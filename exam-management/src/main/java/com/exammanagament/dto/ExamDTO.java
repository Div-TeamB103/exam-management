package com.exammanagament.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
public class ExamDTO {
    private Long id;
    private String examName;
    private Instant startDate;
    private Long adminId;
    private Long examTypeId;
    private Set<Long> examQuestionIds;
    private Set<Long> examStudentIds;




    public ExamDTO() {
    }
}
