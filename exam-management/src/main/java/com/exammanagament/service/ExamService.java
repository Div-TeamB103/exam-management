
package com.exammanagament.service;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.entity.Exam;

import java.util.List;

public interface ExamService {
    ExamDTO creat(ExamDTO examDTO);
    ExamDTO findById(Long id);
    List<ExamDTO> findAll();
    ExamDTO updateById (Long id,ExamDTO examDTO);
    String deleteById (Long id);
}