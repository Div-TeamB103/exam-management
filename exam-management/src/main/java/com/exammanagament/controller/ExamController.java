
package com.exammanagament.controller;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {
    private final ExamService service;

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
    public ExamDTO updateById(@PathVariable Long id,@RequestBody ExamDTO examDTO){
        return service.updateById(id,examDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        return service.deleteById(id);
    }
}