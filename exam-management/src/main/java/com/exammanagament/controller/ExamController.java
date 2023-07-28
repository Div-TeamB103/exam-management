
package com.exammanagament.controller;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.service.ExamService;
import com.exammanagament.exception.UserNotFoundExcemtion;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exam")

public class ExamController {
    private  ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @PostMapping
    public HttpStatusCode creat(ExamDTO examDTO){
         service.creat(examDTO);

         return HttpStatusCode.valueOf(201);

    }

    @GetMapping
    public ResponseEntity<List<ExamDTO>> findAll(){
      return ResponseEntity.ok(service.findAll()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public HttpStatusCode updateById(@PathVariable Long id,@RequestBody ExamDTO examDTO) throws UserNotFoundExcemtion {
        service.updateById(id,examDTO);
        return HttpStatusCode.valueOf(200);
    }

    @DeleteMapping("/{id}")
    public HttpStatusCode deleteById(@PathVariable Long id) throws UserNotFoundExcemtion {
        service.deleteById(id);

        return HttpStatusCode.valueOf(204);
    }



}