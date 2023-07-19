package com.exammanagament.map;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AnswerMap {
    AnswerMap Mapper = Mappers.getMapper(AnswerMap.class);

    AnswerDto dtotoAnswer(AnswerDto answerDto);

    Answer answertoDto(Answer answer);

}
