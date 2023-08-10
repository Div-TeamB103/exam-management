package com.exammanagament.controller;

import com.exammanagament.dto.UserDto;
import com.exammanagament.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService serivce;

    @GetMapping()
    public ResponseEntity<List<UserDto>> findall(){
        return ResponseEntity.ok(serivce.findAll());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<UserDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(serivce.findById(id));
    }
    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto){
        serivce.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody UserDto userDto){
        serivce.updateByIdDto(id,userDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity  delete(@PathVariable Long id){
        serivce.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
