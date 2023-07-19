package com.exammanagament.map;

import com.exammanagament.dto.ExamAdminDto;
import com.exammanagament.entity.ExamAdmin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamAdminMap {
    ExamAdminMap eaMap = Mappers.getMapper(ExamAdminMap.class);
    ExamAdmin eaToDto (ExamAdminDto examAdminDto);
    ExamAdminDto dtoToEa (ExamAdmin examAdmin);

}
