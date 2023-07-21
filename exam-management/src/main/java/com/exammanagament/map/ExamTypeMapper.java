package com.exammanagament.map;

import com.exammanagament.dto.ExamTypeDTO;
import com.exammanagament.entity.ExamType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamTypeMapper {

    @Mapping(source = "exams", target = "examIds")
    ExamTypeDTO examTypeToExamTypeDTO(ExamType examType);



    @InheritInverseConfiguration
    ExamType examTypeDTOtoExamType(ExamTypeDTO examTypeDTO);
}
