package com.exammanagament.service.impl;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import com.exammanagament.exception.DublicateUserException;
import com.exammanagament.exception.NotFoundUserException;
import com.exammanagament.map.ParentMap;
import com.exammanagament.repository.ParentRepository;
import com.exammanagament.service.ParentServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentService implements ParentServiceInterface {
    private final ParentRepository repository;
    private final ParentMap map;

    @Override
    public List<ParentDto> getAllParent() {
        List<Parent> allParent = repository.findAll();
        if (allParent == null) {
            throw new NullPointerException("Hec bir istifadeci tapilmadi");
        }
        return Collections.singletonList(map.toDto((Parent) allParent));
    }

    @Override
    public Optional<ParentDto> getParenyByEmail(ParentDto parentDto, String email) throws NotFoundUserException, NullPointerException {
        if (parentDto == null) {
            throw new NullPointerException("Hec bir istifadeci tapilmadi");
        }
        Optional<Parent> searchDto = repository.findByEmail(parentDto.getEmail());
        if (searchDto.isPresent()) {
            throw new NotFoundUserException("Bu email adresli istifadeci tapilmadi");
        }
        Parent parent = map.toParent(parentDto);
        repository.findByEmail(email);
        return Optional.ofNullable(map.toDto(parent));
    }

    @Override
    public ParentDto createParent(ParentDto parentDto,String email) throws DublicateUserException {
        Optional<Parent> searchDto = repository.findByEmail(email);
        if (searchDto.isPresent()) {
            throw new DublicateUserException("Bu email adresli istifadeci movcuddur");
        } else {
            Parent parent = map.toParent(parentDto);
            repository.save(parent);
            return map.toDto(parent);
        }
    }

    @Override
    public ParentDto updateParent(ParentDto parentDto, Long id) throws NotFoundUserException {
        Optional<Parent> searchDto = repository.findById(id);
        if (searchDto.isPresent()) {
            throw new NotFoundUserException("Bu email adresli istifadeci movcud deyildir.");
        }
        Parent parent = map.toParent(parentDto);
        repository.save(parent);
        return map.toDto(parent);

    }

    @Override
    public ParentDto deleteParent(ParentDto parentDto, Long id) throws NotFoundUserException {
        Optional<Parent> searchDto = repository.findById(id);
        if (searchDto.isPresent()) {
            throw new NotFoundUserException("Bu email adresli istifadeci movcud deyildir.");
        }
        Parent parent = map.toParent(parentDto);
        repository.delete(parent);
        return map.toDto(parent);
    }
}