package com.exammanagament.map;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParentMap {
    ParentMap parentMap = Mappers.getMapper(ParentMap.class);
    Parent parentToDto (ParentDto parentDto);
    ParentDto dtoToParent (Parent parent);
}
