package com.exammanagament.service;

import com.exammanagament.entity.Question;
import com.exammanagament.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuestionService {
    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Optional<Question> getQuestionById(Long id);

    void updateQuestion(Question updateQuestion);

    void deleteQuestion(Long id);


}
