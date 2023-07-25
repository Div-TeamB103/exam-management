package com.exammanagament.service;

import com.exammanagament.entity.Parent;
import com.exammanagament.exception.NotFoundUserException;
import com.exammanagament.dto.ParentDto;
import com.exammanagament.exception.DublicateUserException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ParentServiceInterface {
    public List<ParentDto> getAllParent() ;
    public Optional<ParentDto> getParenyByEmail( String email) throws NullPointerException, NotFoundUserException;
    public ParentDto createParent(ParentDto parentDto) throws DublicateUserException;
    ParentDto updateParent(Long id) throws NotFoundUserException;
    ParentDto deleteParent(Long id) throws NotFoundUserException;
}