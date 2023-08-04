package com.exammanagament.service;

import com.exammanagament.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void createStudent (StudentDto studentDto);
    List<StudentDto>readAllStudents();
    void updateStudentGetById(Long id, StudentDto studentDto);
    void deleteStudentGetById(Long id);
    StudentDto getStudentById(Long id);
}
