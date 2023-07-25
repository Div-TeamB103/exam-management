package com.exammanagament.service.impl;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import com.exammanagament.map.ParentMap;
import com.exammanagament.repository.ParentRepository;
import com.exammanagament.service.ParentServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentService implements ParentServiceInterface {
    private final ParentRepository repository;
    private final ParentMap map;

    @Override
    public List<ParentDto> getAllParent(ParentDto parentDto) throws NullPointerException {
        if (parentDto == null) {
            throw new NullPointerException("Hec bir istifadeci tapilmadi");
        }
        Parent parent = map.toParent(parentDto);
        repository.findAll((Pageable) parent);
        return (List<ParentDto>) map.toDto(parent);
    }

    @Override
    public Optional<ParentDto> getParenyByEmail(ParentDto parentDto) throws NotFoundUserException, NullPointerException {
        if (parentDto == null) {
            throw new NullPointerException("Hec bir istifadeci tapilmadi");
        }
        Optional<Parent> searchDto = repository.findByEmail(parentDto.getEmail());
        if (searchDto.isPresent()) {
            throw new NotFoundUserException("Bu email adresli istifadeci tapilmadi");
        }
        Parent parent = map.toParent(parentDto);
        repository.findByEmail(parent.getEmail());
        return Optional.ofNullable(map.toDto(parent));
    }

    @Override
    public ParentDto createParent(Parent parent) throws DublicateUserException {
        Optional<Parent> searchDto = repository.findByEmail(parent.getEmail());
        if (searchDto.isPresent()) {
            throw new DublicateUserException("Bu email adresli istifadeci movcuddur");
        } else {
            repository.save(parent);
            return map.toDto(parent);
        }
    }

    @Override
    public ParentDto updateParent(ParentDto parentDto) throws NotFoundUserException {
        Optional<Parent> searchDto = repository.findByEmail(parentDto.getEmail());
        if (searchDto.isPresent()) {
            throw new NotFoundUserException("Bu email adresli istifadeci movcud deyildir.");
        }
        Parent parent = map.toParent(parentDto);
        repository.save(parent);
        return map.toDto(parent);

    }

    @Override
    public ParentDto deleteParent(ParentDto parentDto) throws NotFoundUserException {
        Optional<Parent> searchDto = repository.findByEmail(parentDto.getEmail());
        if (searchDto.isPresent()) {
            throw new NotFoundUserException("Bu email adresli istifadeci movcud deyildir.");
        }
        Parent parent = map.toParent(parentDto);
        repository.delete(parent);
        return map.toDto(parent);
    }
}