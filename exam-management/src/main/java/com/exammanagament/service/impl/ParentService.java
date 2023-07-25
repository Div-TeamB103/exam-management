package com.exammanagament.service.impl;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
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
    public Optional<ParentDto> getParenyByEmail(String email) throws NotFoundUserException, NullPointerException {
        Optional<Parent> searchParent = repository.findByEmail(email);
        if (searchParent == null) {
            throw new NullPointerException("Hec bir istifadeci tapilmadi");
        }
        if (searchParent.isPresent()) {
            throw new NotFoundUserException("Bu email adresli istifadeci tapilmadi");
        }
        return Optional.ofNullable(map.toDto(searchParent.get()));
    }

    @Override
    public ParentDto createParent(ParentDto parentDto) throws DublicateUserException {
        Optional<Parent> searchParent = repository.findByEmail(parentDto.getEmail());
        if (searchParent.isPresent()) {
            throw new DublicateUserException("Bu email adresli istifadeci movcuddur");
        } else {
            Parent parent = map.toParent(parentDto);
            repository.save(parent);
            return map.toDto(parent);
        }
    }

    @Override
    public ParentDto updateParent(Long id) throws NotFoundUserException {
        Optional<Parent> searchParent = repository.findById(id);
        if (searchParent.isPresent()) {
            throw new NotFoundUserException("Bu email adresli istifadeci movcud deyildir.");
        }
        repository.save(searchParent.get());
        return map.toDto(searchParent.get());

    }

    @Override
    public ParentDto deleteParent(Long id) throws NotFoundUserException {
       Optional<Parent> searchParent = repository.findById(id);
        if (searchParent.isPresent()) {
            throw new NotFoundUserException("Bu Id de istifadeci movcud deyildir.");
        }
        repository.delete(searchParent.get());
        return null;
    }
}