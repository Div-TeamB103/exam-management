package com.exammanagament.service;

import com.exammanagament.dto.ExamTypeDTO;

import java.util.List;


public interface ExamTypeService {
    void create(ExamTypeDTO examTypeDTO);
    void update(Long id, ExamTypeDTO examTypeDTO);
    List<ExamTypeDTO> findAll();
     void delete(Long id);
    ExamTypeDTO getById(Long id);


}
