package com.exammanagament.service;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.exception.NotFoundUserException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnswerService {
    AnswerDto createAnswer(AnswerDto answerDto);
    List<AnswerDto> readAllAnswer();
    AnswerDto readById(long id);
    AnswerDto updateAnswer(long id, AnswerDto answerDto) throws NotFoundUserException;
    void deleteAnswer(long id) throws NotFoundUserException;
}
