package com.exammanagament.map;

import com.exammanagament.dto.StudentDto;
import com.exammanagament.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMap {
    StudentMap Mapper= Mappers.getMapper(StudentMap.class);

    StudentDto mapToStudentDto(Student student);
    Student mapToStudent(StudentDto studentDto);

}
