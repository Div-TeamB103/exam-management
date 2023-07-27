package com.exammanagament.service;


import com.exammanagament.dto.ParentDto;
import com.exammanagament.exception.DublicateUserException;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.exception.NotFoundUserException;

import java.util.List;
import java.util.Optional;

public interface ParentServiceInterface {

    public List<ParentDto> getAllParent() ;
    public ParentDto getParenyByEmail(String email) throws NotFoundException;
    public ParentDto createParent(ParentDto parentDto) throws DublicateUserException;
    ParentDto updateParent(Long id) throws NotFoundUserException;
    ParentDto deleteParent(Long id) throws NotFoundUserException;

}