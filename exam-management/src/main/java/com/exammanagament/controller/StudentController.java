package com.exammanagament.controller;

import com.exammanagament.dto.StudentDto;
import com.exammanagament.service.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;
    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }
    @GetMapping
    public List<StudentDto>readAllStudents(){
        return studentService.readAllStudents();
    }
    @PutMapping("/{id}")
    public StudentDto updateStudentGetById(@PathVariable Long id,@RequestBody StudentDto studentDto){
        return studentService.updateStudentGetById(id,studentDto);
    }
    @DeleteMapping("/{id}")
    public String deleteStudentGetById(@PathVariable Long id){
     return    studentService.deleteStudentGetById(id);
    }
    @GetMapping("/{id}")
    public StudentDto studentGetById(@PathVariable Long id){
        return studentService.studentGetById(id);
    }



}
