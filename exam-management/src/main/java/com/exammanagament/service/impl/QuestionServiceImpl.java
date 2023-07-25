package com.exammanagament.service.impl;

import com.exammanagament.entity.Question;
import com.exammanagament.repository.QuestionRepository;
import com.exammanagament.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void updateQuestion(Question updateQuestion) {
          questionRepository.save(updateQuestion);
    }

    @Override
    public void deleteQuestion(Long id) {
             questionRepository.deleteById(id);
    }
}
