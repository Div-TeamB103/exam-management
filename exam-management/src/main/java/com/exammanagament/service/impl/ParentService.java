package com.exammanagament.service.impl;

import com.exammanagament.dto.ParentDto;
import com.exammanagament.entity.Parent;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.exception.NotFoundUserException;
import com.exammanagament.map.ParentMap;
import com.exammanagament.repository.ParentRepository;
import com.exammanagament.service.ParentServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentService implements ParentServiceInterface {
    private final ParentRepository repository;
    private final ParentMap map;

    @Override
    public List<ParentDto> getAllParent() {
   return repository.findAll()
            .stream()
            .map(parent -> map.toDto(parent))
            .toList();



    }

    @Override
    public ParentDto getParentById(Long id)  {
        Parent parent = repository.findById(id).orElseThrow(()->new NotFoundException("Istifadeci tapilmadi"));


        return map.toDto(parent);
    }
    @Override
    @Transactional()
    public void updateParent(Long id, ParentDto parentDto)  {
        Parent parent = repository.findById(id).orElseThrow(() -> new NotFoundException ("bele id-li bir Parent tapilmadi" + id ));

        parent.setEmail(parentDto.getEmail());
        parent.setName(parentDto.getName());
        parent.setSurname(parentDto.getSurname());
        parent.setPhoneNumber(parentDto.getPhoneNumber());
        parent.setStatus(parentDto.isStatus());

        try {
            repository.save(parent);
        }catch (RuntimeException exception) {
            throw new RuntimeException("update zamani xeta bas verdi");
        }
    }


    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void createParent(ParentDto parentDto)  {
        Parent parent =map.toParent(parentDto);
        try {
            repository.save(parent);
        }catch (RuntimeException exception){
            throw new RuntimeException("Save zamani xeta bash verdi");
        }
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void deleteParent(Long id){
        if (repository.existsById(id)) {
            try {
                repository.deleteById(id);

            } catch (RuntimeException ex) {
                throw new RuntimeException("Delete zamani xeta bas verdi");
            }
        }else throw new NotFoundException("bele id-li bir Parent tapilmadi");
    }
}