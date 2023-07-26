package com.exammanagament.controller;

import com.exammanagament.dto.ExamTypeDTO;
import com.exammanagament.service.ExamTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam_type")
@RequiredArgsConstructor
public class ExamTypeController {
    private final ExamTypeService examTypeService;
    @PostMapping
    public ExamTypeDTO create(@RequestBody ExamTypeDTO examTypeDTO){
        return examTypeService.create(examTypeDTO);

    }
    @GetMapping("/{id}")
    public  ExamTypeDTO getById(@PathVariable Long id){
        return examTypeService.getById(id);
    }
    @GetMapping
    public List<ExamTypeDTO> getAll(){
        return examTypeService.findAll();
    }
    @PutMapping("/{id}")
    public ExamTypeDTO update(@PathVariable Long id, @RequestBody ExamTypeDTO examTypeDTO){
        return examTypeService.update(id, examTypeDTO);
    }
    @DeleteMapping("/{id}")
    public void  delete(@PathVariable Long id){
         examTypeService.delete(id);
    }

}
