package com.exammanagament.controller;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import com.exammanagament.exception.DublicateUserException;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.exception.NotFoundUserException;
import com.exammanagament.service.ParentServiceInterface;
import com.exammanagament.service.impl.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ParentDto> getParenyByEmail(@PathVariable String email) throws NotFoundException  {
      ParentDto parent = service.getParenyByEmail(email);
    return ResponseEntity.ok(parent);







    }

    @PostMapping("/{email}")
    public ParentDto createParent(@RequestBody ParentDto parentDto) throws DublicateUserException {
        return service.createParent(parentDto);
    }

    @PutMapping("/{id}")
    public ParentDto updateParent(@PathVariable Long id) throws NotFoundUserException {
        return service.updateParent(id);
    }

    @DeleteMapping("/{id}")
    public ParentDto deleteParent(@PathVariable Long id) throws NotFoundUserException {
        return service.deleteParent(id);
    }

}