package com.exammanagament.service;

import com.exammanagament.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuestionService {
    QuestionDTO createQuestion(QuestionDTO questionDTO);

    List<QuestionDTO> getAllQuestions();

    QuestionDTO getQuestionById(Long id);

    QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO);

    String deleteQuestion(Long id);
}
