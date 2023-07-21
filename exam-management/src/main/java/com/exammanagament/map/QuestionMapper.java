package com.exammanagament.map;

import com.exammanagament.dto.QuestionDTO;
import com.exammanagament.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {



    @Mapping(source = "examQuestions", target = "examQuestionIds")
    @Mapping(source = "answers", target = "answerIds")
    QuestionDTO questionToQuestionDTO(Question question);

    @Mapping(target = "examQuestions", ignore = true)
    @Mapping(target = "answers", ignore = true)
    Question questionDTOToQuestion(QuestionDTO questionDTO);


}
