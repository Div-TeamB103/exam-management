package com.exammanagament.map;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.entity.Exam;
import com.exammanagament.entity.ExamAdmin;
import com.exammanagament.entity.ExamQuestion;
import com.exammanagament.entity.ExamStudent;
import com.exammanagament.entity.ExamType;
import com.exammanagament.entity.Question;
import com.exammanagament.entity.Student;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper()
public interface ExamMapper {

    @Mapping(target = "adminId", expression = "java(exam.getAdmin().getId())")
    @Mapping(source = "examType.id", target = "examTypeId")
    @Mapping(target = "examQuestionIds", expression = "java(mapExamQuestionsToIds(exam.getExamQuestions()))")
    @Mapping(target = "examStudentIds", expression = "java(mapExamStudentsToIds(exam.getExamStudents()))")
    ExamDTO examToExamDTO(Exam exam);

    @InheritInverseConfiguration
    Exam examDTOtoExam(ExamDTO examDto);
    @Mapping(target = "examQuestions", ignore = true)
    @Mapping(target = "examStudents", ignore = true)
    @Mapping(target = "id" , ignore = true)
    void updateExamFromDTO(ExamDTO examDTO, @MappingTarget Exam exam);


    default Set<Long> mapExamQuestionsToIds(Set<ExamQuestion> examQuestions) {
      return  examQuestions
              .stream()
              .map(examQuestion -> examQuestion.getQuestion().getId())
              .collect(Collectors.toSet());
    }

    default Set<Long> mapExamStudentsToIds(Set<ExamStudent> examStudents) {
        return examStudents
                .stream()
                .map(examStudent -> examStudent.getStudent().getId())
                .collect(Collectors.toSet());
    }

    default Set<ExamQuestion> mapExamQuestionIdsToExamQuestions(Set<Long> examQuestionIds) {
        return examQuestionIds
                .stream()
                .map(aLong -> {
                    ExamQuestion examQuestion =new ExamQuestion();

                    examQuestion.setQuestion(longToQuestion(aLong));
                    return examQuestion;
                } ).collect(Collectors.toSet());

    }
    default Question longToQuestion(Long id ){
        Question  question = new Question();
        question.setId(id);
        return question;
    }



    default Set<ExamStudent> mapExamStudentIdsToExamStudents(Set<Long> examStudentIds) {
        return examStudentIds.stream()
                .map(id -> {
                    ExamStudent examStudent = new ExamStudent();
                    examStudent.setStudent(longToStudent(id));
                    return examStudent;
                })
                .collect(Collectors.toSet());
    }

    default Student longToStudent(Long id){
        Student student = new Student();
        student.setId(id);
        return student;
    }

    default ExamType mapLongToExamType(Long examTypeId) {
        ExamType examType = new ExamType();
        examType.setId(examTypeId);
        return examType;

    }

    default ExamAdmin mapLongToExamAdmin(Long examAdminId) {
        ExamAdmin examAdmin = new ExamAdmin();
        examAdmin.setId(examAdminId);
        return examAdmin;

    }

}
