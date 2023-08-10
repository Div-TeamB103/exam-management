package com.exammanagament.service.impl;

import com.exammanagament.dto.UserDto;
import com.exammanagament.entity.User;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.map.UserMapper;
import com.exammanagament.repository.UserRepository;
import com.exammanagament.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    @Override
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void save(UserDto  userDto) {
        User user = mapper.dtoToEntity(userDto);
        try {
            userRepository.save(user);
        } catch (RuntimeException ex) {
            throw new RuntimeException("Save zamanı xəta baş verdi", ex);
        }
    }
    @Override
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void updateByIdDto(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Bele id-li Bir User tapılmadı: " + id));
        mapper.updateByDto(user,userDto);
        try {
            userRepository.save(user);

        } catch (RuntimeException ex) {
            throw new RuntimeException("Update zamanı xəta baş verdi", ex);
        }
    }
    @Override

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .toList();


    }
    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void deleteById(Long id) {
        if(userRepository.existsById(id)){
            try {
                userRepository.deleteById(id);
            }catch (RuntimeException ex){

                throw  new RuntimeException("Silinme zamanı xəta baş verdi" , ex);
            }
        }else throw new NotFoundException("Bu idli User tapılmadı");

    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("Bele id-li User tapılmadı"));
        UserDto userDto = mapper.entityToDto(user);
        return userDto;
    }
}
