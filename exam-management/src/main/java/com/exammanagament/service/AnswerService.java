package com.exammanagament.service;

import com.exammanagament.dto.AnswerDto;

import java.util.List;

public interface AnswerService {
    void createAnswer(AnswerDto answerDto);
    List<AnswerDto> readAllAnswer();
    AnswerDto readById(long id);
    void updateAnswer(long id, AnswerDto answerDto);
    void deleteAnswer(long id);
}
