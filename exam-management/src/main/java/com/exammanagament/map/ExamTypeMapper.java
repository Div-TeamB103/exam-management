package com.exammanagament.map;

import com.exammanagament.dto.ExamTypeDTO;
import com.exammanagament.entity.Exam;
import com.exammanagament.entity.ExamType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ExamTypeMapper {

    @Mapping(source = "exams", target = "examIds")
    ExamTypeDTO examTypeToExamTypeDTO(ExamType examType);

    @InheritInverseConfiguration
    ExamType examTypeDTOtoExamType(ExamTypeDTO examTypeDTO);

    default Set<Long> mapExamsToExamIds(Set<Exam> exams) {
        return exams.stream()
                .map(Exam::getId)
                .collect(Collectors.toSet());
    }

    default Set<Exam> mapExamIdsToExams(Set<Long> examIds) {
        return examIds.stream()
                .map(id -> {
                    Exam exam = new Exam();
                    exam.setId(id);
                    return exam;
                })
                .collect(Collectors.toSet());
    }
}
