package com.exammanagament.map;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.entity.Exam;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam mapToExamEntity(ExamDTO examDTO);

    List<ExamDTO> mapToExamDtoList(List<Exam> exams);

    ExamDTO mapToExamDto(Exam exam);

}
