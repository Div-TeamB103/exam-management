
package com.exammanagament.controller;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.service.ExamService;
import com.exammanagament.service.impl.UserNotFoundExcemtion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ExamController {
    private final ExamService service;

    @PostMapping
    public ExamDTO creat(@RequestBody  ExamDTO examDTO){
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