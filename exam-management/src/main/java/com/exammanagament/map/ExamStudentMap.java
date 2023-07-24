package com.exammanagament.map;

import com.exammanagament.dto.ExamStudentDto;
import com.exammanagament.entity.Exam;
import com.exammanagament.entity.ExamStudent;
import com.exammanagament.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ExamStudentMap {
    @Mapping(target = "exam", expression = "java(toExam(dto.getExam_id()))")
    @Mapping(target = "student", expression = "java(toStudent(dto.getStudent_id()))")
    ExamStudent toEntity (ExamStudentDto dto);
    @Mapping(target = "exam_id", expression = "java(examToLong(entity.getExam()))")
    @Mapping(target = "student_id", expression = "java(studentToLong(entity.getStudent()))")
    ExamStudentDto toDto(ExamStudent entity);
    default Long examToLong(Exam exam){
        return exam.getId();
    }
    default Long studentToLong(Student student){
        return student.getId();
    }
    default Exam toExam(Long examId){
        Exam exam =new Exam();
        exam.setId(examId);
        return exam;
    }
    default Student toStudent(Long studentId){
        Student student = new Student();
        student.setId(studentId);
        return student;
    }
}