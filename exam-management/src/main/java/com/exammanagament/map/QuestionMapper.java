package com.exammanagament.map;

import com.exammanagament.dto.QuestionDTO;
import com.exammanagament.entity.ExamQuestion;
import com.exammanagament.entity.Question;
import com.exammanagament.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    @Mapping(target = "examQuestionIds", expression = "java(mapExamQuestionsToIds(question.getExamQuestions()))")
    @Mapping(target = "answerIds", expression = "java(mapAnswersToIds(question.getAnswers()))")
    QuestionDTO questionToQuestionDTO(Question question);

    @Mapping(target = "examQuestions", ignore = true)
    @Mapping(target = "answers", ignore = true)
    Question questionDTOToQuestion(QuestionDTO questionDTO);

    default Set<Long> mapExamQuestionsToIds(Set<ExamQuestion> examQuestions) {
        return examQuestions.stream()
                .map(ExamQuestion::getId)
                .collect(Collectors.toSet());
    }

    default Set<Long> mapAnswersToIds(Set<Answer> answers) {
        return answers.stream()
                .map(Answer::getId)
                .collect(Collectors.toSet());
    }

    default Set<ExamQuestion> mapExamQuestionIdsToExamQuestions(Set<Long> examQuestionIds) {
        return examQuestionIds.stream()
                .map(id -> {
                    ExamQuestion examQuestion = new ExamQuestion();
                    examQuestion.setId(id);
                    return examQuestion;
                })
                .collect(Collectors.toSet());
    }

    default Set<Answer> mapAnswerIdsToAnswers(Set<Long> answerIds) {
        return answerIds.stream()
                .map(id -> {
                    Answer answer = new Answer();
                    answer.setId(id);
                    return answer;
                })
                .collect(Collectors.toSet());
    }
}
