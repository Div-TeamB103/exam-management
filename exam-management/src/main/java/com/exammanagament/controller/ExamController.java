
package com.exammanagament.controller;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.service.ExamService;
import com.exammanagament.exception.UserNotFoundExcemtion;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class ExamController {
    private  ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @PostMapping
    public ExamDTO creat(ExamDTO examDTO){
        return service.creat(examDTO);
    }

    @GetMapping
    public List<ExamDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ExamDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ExamDTO updateById(@PathVariable Long id,@RequestBody ExamDTO examDTO) throws UserNotFoundExcemtion {
        return service.updateById(id,examDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) throws UserNotFoundExcemtion {
        return service.deleteById(id);
    }



}