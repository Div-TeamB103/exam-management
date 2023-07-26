package com.exammanagament.service.impl;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.entity.Answer;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.exception.NotFoundUserException;
import com.exammanagament.map.AnswerMap;
import com.exammanagament.repository.AnswerRepository;
import com.exammanagament.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository repository;
    private final AnswerMap answerMap;

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        return answerMap.mapToAnswerDto(repository.save(answerMap.mapToAnswer(answerDto)));
    }

    @Override
    public List<AnswerDto> readAllAnswer() {
        return repository.findAll()
                .stream()
                .map(answerMap::mapToAnswerDto)
                .toList();
    }

    @Override
    public AnswerDto readById(long id) {
        return answerMap.mapToAnswerDto(repository.findById(id).orElse(null));
    }

    @Override
    public AnswerDto updateAnswer(long id, AnswerDto answerDto) throws NotFoundUserException {
        Answer oldAnswer1 = repository.findById(id).orElse(null);
        AnswerDto oldAnswer = answerMap.mapToAnswerDto(oldAnswer1);
        if (oldAnswer != null) {
            oldAnswer.setOption(answerDto.getOption());
            oldAnswer.setCorrect(answerDto.isCorrect());
            return answerMap.mapToAnswerDto(repository.save(answerMap.mapToAnswer(oldAnswer)));

        } throw new NotFoundException("Not found");


    }

    @Override
    public void deleteAnswer(long id) throws NotFoundUserException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Not found");

    }
}
