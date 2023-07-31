package com.exammanagament.service;


import com.exammanagament.dto.ParentDto;
import com.exammanagament.exception.DublicateUserException;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.exception.NotFoundUserException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ParentServiceInterface {

    List<ParentDto> getAllParent() ;
    ParentDto getParentById(Long id) throws NotFoundException;
    void createParent(ParentDto parentDto);
    void updateParent(Long id, ParentDto parentDto);

    void deleteParent(Long id) throws NotFoundUserException;

}