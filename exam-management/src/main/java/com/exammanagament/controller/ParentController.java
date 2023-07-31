package com.exammanagament.controller;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import com.exammanagament.exception.DublicateUserException;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.exception.NotFoundUserException;
import com.exammanagament.service.ParentServiceInterface;
import com.exammanagament.service.impl.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/parent")
@RequiredArgsConstructor
public class ParentController {
    private final ParentServiceInterface service;

    @GetMapping
    public ResponseEntity<List<ParentDto>> getAllParent() {
        return  ResponseEntity.ok(service.getAllParent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentDto> getParentById(@PathVariable Long id) throws NotFoundException {
        ParentDto parent = service.getParentById(id);
        return ResponseEntity.ok(parent);


    }

    @PostMapping()
    public ResponseEntity createParent(@RequestBody ParentDto parentDto) {
        service.createParent(parentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateParent(@PathVariable Long id, @RequestBody ParentDto parentDto)  {
        service.updateParent(id, parentDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) throws NotFoundUserException {
        service.deleteParent(id);
    }

}