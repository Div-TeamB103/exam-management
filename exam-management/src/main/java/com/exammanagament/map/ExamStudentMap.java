package com.exammanagament.map;

import com.exammanagament.dto.ExamStudentDto;
import com.exammanagament.entity.ExamStudent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ExamStudentMap {
    @Mapping(target = "exam", source = "exam_id")
    @Mapping(target = "student", source = "student_id")
    ExamStudent toEntity (ExamStudentDto dto);
}