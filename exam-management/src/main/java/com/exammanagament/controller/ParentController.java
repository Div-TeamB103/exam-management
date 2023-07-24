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
public class ParentController {
    private final ParentServiceInterface service;

    @GetMapping
    public List<ParentDto> getAllParent() {
        return service.getAllParent();
    }

    @GetMapping("/{email}")
    public Optional<ParentDto> getParenyByEmail(@RequestBody ParentDto parentDto, @PathVariable String email) throws NotFoundUserException {
        return service.getParenyByEmail(parentDto, email);
    }

    @PostMapping("/{email}")
    public ParentDto createParent(@RequestBody ParentDto parentDto, @PathVariable String email) throws DublicateUserException {
        return service.createParent(parentDto, email);
    }

    @PutMapping("/{id}")
    public ParentDto updateParent(@RequestBody ParentDto parentDto, @PathVariable Long id) throws NotFoundUserException {
        return service.updateParent(parentDto, id);
    }

    @DeleteMapping("/{id}")
    public ParentDto deleteParent(@RequestBody ParentDto parentDto, @PathVariable Long id) throws NotFoundUserException {
        return service.updateParent(parentDto, id);
    }
}