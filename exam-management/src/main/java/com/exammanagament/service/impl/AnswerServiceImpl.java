package com.exammanagament.service.impl;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.entity.Answer;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.map.AnswerMap;
import com.exammanagament.map.QuestionMapper;
import com.exammanagament.repository.AnswerRepository;
import com.exammanagament.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository repository;
    private final AnswerMap answerMap;

    private final QuestionMapper questionMapper;

    @Override
    @Transactional
    public void createAnswer(AnswerDto answerDto) {
        Answer answer = answerMap.mapToAnswer(answerDto);
        repository.save(answer);




    }

    @Override
    public List<AnswerDto> readAllAnswer() {
        return repository.findAll()
                .stream()
                .map(answer -> answerMap.mapToAnswerDto(answer))
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDto readById(long id) throws NotFoundException {

        Answer answer = repository.findById(id).orElseThrow(() -> new NotFoundException("Verilmiş İD-li sual tapılmadı: " + id));
        return answerMap.mapToAnswerDto(answer);

    }

    @Override
    @Transactional
    public void updateAnswer(long id, AnswerDto answerDto) {
        Answer answer = repository.findById(id).orElseThrow(() -> new NotFoundException("Verilmiş İD-li sual tapılmadı: " + id));

        if(answerDto.getQuestionDTO()!=null) {
            answer.setQuestion(questionMapper.questionDTOToQuestion(answerDto.getQuestionDTO()));
        }

        answer.setOption(answerDto.getOption());
        answer.setCorrect(answerDto.isCorrect());

        try {
            repository.save(answer);
        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }

    @Override
    @Transactional
    public void deleteAnswer(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }else{
            throw new NotFoundException("Verilmiş İD-li sual tapılmadı:" + id);
        }

    }
}
