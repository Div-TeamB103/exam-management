package com.exammanagament.service.impl;

import com.exammanagament.dto.ExamTypeDTO;
import com.exammanagament.entity.ExamType;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.map.ExamTypeMapper;
import com.exammanagament.repository.ExamTypeRepository;
import com.exammanagament.service.ExamTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ExamTypeServiceImpl implements ExamTypeService {
    private final ExamTypeRepository examTypeRepository;
    private final ExamTypeMapper examTypeMapper;


    @Override
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void create(ExamTypeDTO examTypeDTO) {
        ExamType examType = examTypeMapper.examTypeDTOtoExamType(examTypeDTO);


        try {
   examTypeRepository.save(examType);
        } catch (RuntimeException ex) {
            throw new RuntimeException("Save zamanı xəta baş verdi", ex);
        }

    }

    @Override
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void update(Long id, ExamTypeDTO examTypeDTO) {
        ExamType examType = examTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("Bele id-li Bir ExamType tapılmadı: " + id));

        examType.setType(examTypeDTO.getType());
        examType.setExams(examTypeMapper.mapExamIdsToExams(examTypeDTO.getExamIds()));
        examType.setDescription(examTypeDTO.getDescription());

        try {
            examTypeRepository.save(examType);

        } catch (RuntimeException ex) {

            throw new RuntimeException("Update zamanı xəta baş verdi", ex);

        }


    }

    @Override

    public List<ExamTypeDTO> findAll() {
        return examTypeRepository.findAll()
                .stream()
                .map(examType -> examTypeMapper.examTypeToExamTypeDTO(examType))
                .toList();
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void delete(Long id) {

        if(examTypeRepository.existsById(id)){
            try {
                examTypeRepository.deleteById(id);
            }catch (RuntimeException ex){
                   throw  new RuntimeException("Silinme zamanı xəta baş verdi" , ex);


            }
        }else throw new NotFoundException("Bu idli examtype tapılmadı");

    }

    @Override
    public ExamTypeDTO getById(Long id) {
        ExamType examType = examTypeRepository.findById(id).orElseThrow(()-> new NotFoundException("Bele id-li ExamType tapılmadı"));

         return examTypeMapper.examTypeToExamTypeDTO(examType);


    }
}
