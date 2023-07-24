package com.exammanagament.map;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParentMap {
    Parent toParent (ParentDto parentDto);
    ParentDto toDto (Parent parent);
}
