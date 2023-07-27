
package com.exammanagament.service;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.exception.UserNotFoundExcemtion;

import java.util.List;

public interface ExamService {
    ExamDTO creat(ExamDTO examDTO);
    ExamDTO findById(Long id);
    List<ExamDTO> findAll();
    ExamDTO updateById (Long id,ExamDTO examDTO) throws UserNotFoundExcemtion;
    String deleteById (Long id) throws UserNotFoundExcemtion;
}