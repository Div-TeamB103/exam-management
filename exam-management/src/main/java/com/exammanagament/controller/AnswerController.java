package com.exammanagament.controller;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.exception.NotFoundUserException;
import com.exammanagament.service.impl.AnswerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
    private final AnswerServiceImpl answerServiceImpl;

    @PostMapping
    public AnswerDto createAnswer(@RequestBody AnswerDto answerDto) {
        return answerServiceImpl.createAnswer(answerDto);
    }

    @GetMapping
    public List<AnswerDto> readAllAnswer() {
        return answerServiceImpl.readAllAnswer();
    }

    @GetMapping("/{id}")
    public AnswerDto readById(@PathVariable long id)  {
        return answerServiceImpl.readById(id);
    }

    @PostMapping("/{id}")
    public AnswerDto updateAnswer(@PathVariable long id, @RequestBody AnswerDto answerDto) throws NotFoundUserException {
        return answerServiceImpl.updateAnswer(id, answerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable long id) throws NotFoundUserException {
        answerServiceImpl.deleteAnswer(id);
    }
}
