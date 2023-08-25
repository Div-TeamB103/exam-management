package com.exammanagament.map;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.entity.Exam;
import com.exammanagament.entity.ExamQuestion;
import com.exammanagament.entity.ExamStudent;
import com.exammanagament.entity.ExamType;
import com.exammanagament.entity.Question;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper()
public interface ExamMapper {

   
    @Mapping(source = "examType.id", target = "examTypeId")
    @Mapping(target = "examQuestionIds", expression = "java(mapExamQuestionsToIds(exam.getExamQuestions()))")
    @Mapping(target = "examStudentIds", expression = "java(mapExamStudentsToIds(exam.getExamStudents()))")
    ExamDTO examToExamDTO(Exam exam);

    @InheritInverseConfiguration
    Exam examDTOtoExam(ExamDTO examDto);
    @Mapping(target = "examQuestions", ignore = true)
    @Mapping(target = "userList", ignore = true)
    @Mapping(target = "id" , ignore = true)
    void updateExamFromDTO(ExamDTO examDTO, @MappingTarget Exam exam);



}
