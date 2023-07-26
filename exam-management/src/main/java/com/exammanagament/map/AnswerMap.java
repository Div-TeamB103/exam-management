package com.exammanagament.map;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.entity.Answer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = QuestionMapper.class)
public interface AnswerMap {


    AnswerDto mapToAnswerDto(Answer answer);



    Answer mapToAnswer(AnswerDto answerDto);




}
