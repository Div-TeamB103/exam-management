
package com.exammanagament.service;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.exception.UserNotFoundExcemtion;

import java.util.List;

public interface ExamService {
    void create(ExamDTO examDTO);
    ExamDTO findById(Long id);
    List<ExamDTO> findAll();
    void updateById (Long id, ExamDTO examDTO) throws UserNotFoundExcemtion;
    void deleteById (Long id) throws UserNotFoundExcemtion;
}