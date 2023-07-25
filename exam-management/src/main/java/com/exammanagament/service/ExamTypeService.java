package com.exammanagament.service;

import com.exammanagament.dto.ExamTypeDTO;
import com.exammanagament.entity.ExamType;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface ExamTypeService {
    List<ExamTypeDTO> findAll();
    ExamTypeDTO findById(Long id);
    ExamTypeDTO save(ExamTypeDTO examTypeDTO);
    String delete(Long id);
    ExamTypeDTO update(Long id,ExamTypeDTO examTypeDTO);

}
