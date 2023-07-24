package com.exammanagament.map;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper()
public interface ParentMap {
    @Mapping(target = "password", source = "")
    @Mapping(target = "lastLoginDate", expression = "java(new Date)")
    Parent toParent (ParentDto parentDto);
    ParentDto toDto (Parent parent);
}
