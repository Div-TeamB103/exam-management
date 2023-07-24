package com.exammanagament.controller;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import com.exammanagament.exception.DublicateUserException;
import com.exammanagament.exception.NotFoundUserException;
import com.exammanagament.service.ParentServiceInterface;
import com.exammanagament.service.impl.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentController  {
    private final ParentService service;

    @GetMapping

    public List<ParentDto> getAllParent(ParentDto parentDto) throws NullPointerException {
        return service.getAllParent(parentDto);
    }

    @GetMapping("/byEmail")

    public Optional<ParentDto> getParenyByEmail(ParentDto parentDto) throws NullPointerException, NotFoundUserException {
        return service.getParenyByEmail(parentDto);
    }

    @PostMapping

    public ParentDto createParent(Parent parent) throws DublicateUserException {
        return service.createParent(parent);
    }

    @PutMapping

    public ParentDto updateParent(ParentDto parentDto) throws NotFoundUserException {
        return service.updateParent(parentDto);
    }

    @DeleteMapping

    public ParentDto deleteParent(ParentDto parentDto) throws NotFoundUserException {
        return service.updateParent(parentDto);
    }
}