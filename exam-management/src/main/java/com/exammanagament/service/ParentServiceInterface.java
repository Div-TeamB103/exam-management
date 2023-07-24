package com.exammanagament.service;

import com.exammanagament.entity.Parent;
import com.exammanagament.exception.NotFoundUserException;
import com.exammanagament.dto.ParentDto;
import com.exammanagament.exception.DublicateUserException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ParentServiceInterface {
    public List<ParentDto> getAllParent(ParentDto parentDto) throws NullPointerException;
    public Optional<ParentDto> getParenyByEmail(ParentDto parentDto) throws NullPointerException, NotFoundUserException;
    public ParentDto createParent(Parent parent) throws DublicateUserException;
    ParentDto updateParent(ParentDto parentDto) throws NotFoundUserException;
    ParentDto deleteParent(ParentDto parentDto) throws NotFoundUserException;
}