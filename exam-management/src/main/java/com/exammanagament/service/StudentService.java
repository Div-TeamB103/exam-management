package com.exammanagament.service;

import com.exammanagament.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent (StudentDto studentDto);
    List<StudentDto>readAllStudents();
    StudentDto updateStudentGetById(Long id,StudentDto studentDto);
    String deleteStudentGetById(Long id);
    StudentDto studentGetById(Long id);
}
