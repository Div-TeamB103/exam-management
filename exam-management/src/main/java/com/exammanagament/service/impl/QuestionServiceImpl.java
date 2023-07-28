package com.exammanagament.service.impl;

import com.exammanagament.dto.QuestionDTO;
import com.exammanagament.entity.Question;
import com.exammanagament.map.QuestionMapper;
import com.exammanagament.repository.QuestionRepository;
import com.exammanagament.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper mapper;

    @Override
    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        return mapper.questionToQuestionDTO(questionRepository.save(mapper.questionDTOToQuestion(questionDTO)));
    }

    @Override
    public List<QuestionDTO> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(mapper::questionToQuestionDTO)
                .toList();
    }

    @Override
    public QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO) {
        Question oldQuestion = questionRepository.findById(id).orElse(null);
        if (oldQuestion != null) {
            questionDTO.setQuestionName(questionDTO.getQuestionName());
            questionDTO.setExamQuestionIds(questionDTO.getExamQuestionIds());
            questionDTO.setId(questionDTO.getId());
            questionDTO.setAnswerIds(questionDTO.getAnswerIds());
            return mapper.questionToQuestionDTO(questionRepository.save(mapper.questionDTOToQuestion(questionDTO)));
        } else {
            return null;
        }
    }

    @Override
    public String deleteQuestion(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return id + "-li silindi";
        } else {
            return id + "-li tapilmadi";
        }
    }
    @Override
    public QuestionDTO getQuestionById(Long id) {
        return mapper.questionToQuestionDTO(questionRepository.findById(id).orElse(null));
    }

}
