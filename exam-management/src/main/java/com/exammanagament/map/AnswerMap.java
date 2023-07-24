package com.exammanagament.map;

import com.exammanagament.dto.AnswerDto;
import com.exammanagament.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AnswerMap {

    Answer toEntity(AnswerDto dto);
    AnswerDto toDto(Answer answer);
}
