package com.exammanagament.controller;

import com.exammanagament.dto.StudentDto;
import com.exammanagament.entity.Student;
import com.exammanagament.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity creatStudent(@RequestBody StudentDto studentDto) {
        studentService.createStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<StudentDto> readAllStudents() {
        return studentService.readAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> studentGetById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateGetById(@PathVariable(name = "id") long id, @RequestBody StudentDto studentDto) {
        studentService.updateStudentGetById(id,studentDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
         studentService.deleteStudentGetById(id);

         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
