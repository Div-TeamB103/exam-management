package com.exammanagament.controller;

import com.exammanagament.dto.ExamTypeDTO;
import com.exammanagament.service.impl.ExamTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examtype")
@RequiredArgsConstructor
public class ExamTypeController {

    private final ExamTypeServiceImpl examTypeService;

    @GetMapping
    public List<ExamTypeDTO> findAll(){
        return examTypeService.findAll();
    }
    @GetMapping("/{id}")
    public ExamTypeDTO findById(@PathVariable(name = "id") Long id, @RequestBody ExamTypeDTO examTypeDTO){
        return examTypeService.findById(id);
    }
    @PostMapping
    public ExamTypeDTO save(@RequestBody ExamTypeDTO examTypeDTO){
        return examTypeService.save(examTypeDTO);
    }
    @PutMapping("/{id}")
    public ExamTypeDTO update(@PathVariable(name = "id") Long id,@RequestBody ExamTypeDTO examTypeDTO){
        return examTypeService.update(id, examTypeDTO);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Long id){
         examTypeService.delete(id);
         return "Silindi";
    }
}
