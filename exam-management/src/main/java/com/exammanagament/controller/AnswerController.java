package com.exammanagament.controller;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.entity.Answer;
import com.exammanagament.service.AnswerService;
import com.exammanagament.service.impl.AnswerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {

    private AnswerService answerService;


    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public ResponseEntity<List<AnswerDto>> getAllAnswers(){
        return ResponseEntity.ok(answerService.readAllAnswer());

    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDto> getAnswerById(@PathVariable(name = "id") Long id){

        return ResponseEntity.ok(answerService.readById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatusCode> updateAnswer(@PathVariable(name = "id") Long id , @RequestBody AnswerDto answerDto ){
             answerService.updateAnswer(id , answerDto);
        return ResponseEntity.ok(HttpStatus.OK);


    }

    @PostMapping
    public ResponseEntity createAnswer (@RequestBody AnswerDto answerDto){

        answerService.createAnswer(answerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAnswer(@PathVariable(name = "id") Long id){
        answerService.deleteAnswer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }




}
