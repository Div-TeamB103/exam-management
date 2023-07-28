package com.exammanagament.service;

import com.exammanagament.dto.ExamTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ExamTypeService {
    ExamTypeDTO create(ExamTypeDTO examTypeDTO);
    ExamTypeDTO update(Long id, ExamTypeDTO examTypeDTO);
    List<ExamTypeDTO> findAll();
     void delete(Long id);
    ExamTypeDTO getById(Long id);


}
