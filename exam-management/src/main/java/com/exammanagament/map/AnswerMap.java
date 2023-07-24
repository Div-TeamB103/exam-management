package com.exammanagament.map;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMap {


    @Mapping(target = "isCorrect", source = "correct")
    AnswerDto mapToAnswerDto(Answer answer);

    @Mapping(target = "correct", source = "isCorrect")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "question", ignore = true)
    Answer mapToAnswer(AnswerDto answerDto);

}
