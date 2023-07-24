package com.exammanagament.map;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.entity.Exam;
import com.exammanagament.entity.ExamQuestion;
import com.exammanagament.entity.ExamStudent;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ExamMapper {

    @Mapping(source = "admin.id", target = "adminId")
    @Mapping(source = "examType.id", target = "examTypeId")
    @Mapping(target = "examQuestionIds", expression = "java(mapExamQuestionsToIds(exam.getExamQuestions()))")
    @Mapping(target = "examStudentIds", expression = "java(mapExamStudentsToIds(exam.getExamStudents()))")
    ExamDTO examToExamDTO(Exam exam);

    @InheritInverseConfiguration
    Exam examDTOtoExam(ExamDTO examDto);

    default Set<Long> mapExamQuestionsToIds(Set<ExamQuestion> examQuestions) {
        return examQuestions.stream()
                .map(ExamQuestion::getId)
                .collect(Collectors.toSet());
    }

    default Set<Long> mapExamStudentsToIds(Set<ExamStudent> examStudents) {
        return examStudents.stream()
                .map(ExamStudent::getId)
                .collect(Collectors.toSet());
    }

    default Set<ExamQuestion> mapExamQuestionIdsToExamQuestions(Set<Long> examQuestionIds) {
        return examQuestionIds.stream()
                .map(id -> {
                    ExamQuestion examQuestion = new ExamQuestion();
                    examQuestion.setId(id);
                    return examQuestion;
                })
                .collect(Collectors.toSet());
    }

    default Set<ExamStudent> mapExamStudentIdsToExamStudents(Set<Long> examStudentIds) {
        return examStudentIds.stream()
                .map(id -> {
                    ExamStudent examStudent = new ExamStudent();
                    examStudent.setId(id);
                    return examStudent;
                })
                .collect(Collectors.toSet());
    }
}
