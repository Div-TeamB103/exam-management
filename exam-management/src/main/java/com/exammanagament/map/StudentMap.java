package com.exammanagament.map;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.dto.StudentDto;
import com.exammanagament.entity.Exam;
import com.exammanagament.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMap {
    StudentMap Mapper= Mappers.getMapper(StudentMap.class);

    StudentDto mapToStudentDto(Student student);
    Student mapToStudent(StudentDto studentDto);

    @Mapping(target = "birthDate", ignore = true)
    @Mapping(target = "lastLoginDate", ignore = true)
    @Mapping(target = "joinDate", ignore = true)
    @Mapping(target = "examStudents", ignore = true)
    @Mapping(target = "id" , ignore = true)
    void updateStudentFromDTO(StudentDto studentDto, @MappingTarget Student student);

}
