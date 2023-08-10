package com.exammanagament.map;

import com.exammanagament.dto.UserDto;
import com.exammanagament.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;

@Mapper(imports = {LocalDateTime.class})
public abstract class UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "lastLoginIp", ignore = true)
    @Mapping(target = "joinDate", expression = "java(LocalDateTime.now())")
    @Mapping(target = "lastLoginDate", expression = "java(LocalDateTime.now())")
    @Mapping(target = "status", constant = "false")
    public abstract User dtoToEntity(UserDto userDto);

    public abstract UserDto entityToDto (User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "joinDate", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "lastLoginIp", ignore = true)
    @Mapping(target = "lastLoginDate", ignore = true)
    public abstract void updateByDto(@MappingTarget User user, UserDto dto);

    @Mapping(target = "lastLoginDate", expression = "java(LocalDateTime.now())")
    public abstract void updateLastLoginDate(@MappingTarget User user);
}
