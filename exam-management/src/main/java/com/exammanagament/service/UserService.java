package com.exammanagament.service;

import com.exammanagament.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto signup);
    UserDto findById(Long id);
    List<UserDto> findAll();
    void updateByIdDto(Long id, UserDto dto);
    void deleteById(Long id);
}
