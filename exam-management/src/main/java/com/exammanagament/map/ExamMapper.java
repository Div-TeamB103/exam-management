package com.exammanagament.map;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.entity.Exam;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamMapper {

    @Mapping(source = "admin.id", target = "adminId")
    @Mapping(source = "examType.id", target = "examTypeId")
    @Mapping(source = "examQuestions", target = "examQuestionIds")
    @Mapping(source = "examStudents", target = "examStudentIds")
    ExamDTO examToExamDTO(Exam exam);


    @InheritInverseConfiguration
    Exam examDTOtoExam(ExamDTO examDto);

}
