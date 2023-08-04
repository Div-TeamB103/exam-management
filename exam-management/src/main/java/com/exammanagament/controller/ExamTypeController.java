package com.exammanagament.controller;

import com.exammanagament.dto.ExamTypeDTO;
import com.exammanagament.service.ExamTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
@RequestMapping("/api/v1/examtypes")
@RequiredArgsConstructor
public class ExamTypeController {
    private final ExamTypeService examTypeService;
    @PostMapping
    public ResponseEntity create(@RequestBody ExamTypeDTO examTypeDTO){
    examTypeService.create(examTypeDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    @GetMapping("/{id}")
    public  ResponseEntity<ExamTypeDTO> getById(@PathVariable Long id){
       return ResponseEntity.ok(examTypeService.getById(id));


    }
    @GetMapping
    public ResponseEntity<List<ExamTypeDTO>> getAll(){
        return ResponseEntity.ok( examTypeService.findAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody ExamTypeDTO examTypeDTO){
       examTypeService.update(id, examTypeDTO);
       return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity  delete(@PathVariable Long id){
         examTypeService.delete(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
