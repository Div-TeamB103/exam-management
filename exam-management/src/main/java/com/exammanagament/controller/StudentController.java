package com.exammanagament.controller;

import com.exammanagament.dto.StudentDto;
import com.exammanagament.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

   @PostMapping
    public StudentDto creatStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }
   @GetMapping
  public List<StudentDto> readAllStudents(){
  return   studentService.readAllStudents();
   }

  @GetMapping("/{id}")

    public  StudentDto studentGetById(@PathVariable long id){
     return   studentService.studentGetById(id);
  }
  @PutMapping("/{id}")
    public  StudentDto updateGetById( @PathVariable long id,@RequestBody StudentDto studentDto ){
       return  studentService.updateStudentGetById(id,studentDto);
  }

  @DeleteMapping("/{id}")
    public String  deleteStudent(@PathVariable long id){
     return   studentService.deleteStudentGetById(id);
  }

}
