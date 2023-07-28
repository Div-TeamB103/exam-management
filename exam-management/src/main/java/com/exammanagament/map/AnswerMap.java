package com.exammanagament.map;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = QuestionMapper.class)
public interface AnswerMap {


    @Mapping(target = "questionDTO", source = "question")
    AnswerDto mapToAnswerDto(Answer answer);

    @Mapping(target = "question", source = "questionDTO")
    Answer mapToAnswer(AnswerDto answerDto);

}