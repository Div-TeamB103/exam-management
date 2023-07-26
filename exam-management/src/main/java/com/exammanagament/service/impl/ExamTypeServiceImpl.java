package com.exammanagament.service.impl;

import com.exammanagament.dto.ExamTypeDTO;
import com.exammanagament.entity.ExamType;
import com.exammanagament.map.ExamTypeMapper;
import com.exammanagament.repository.ExamTypeRepository;
import com.exammanagament.service.ExamTypeService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

public class ExamTypeServiceImpl implements ExamTypeService {
    private final ExamTypeRepository examTypeRepository;
    private final ExamTypeMapper examTypeMapper;



    @Override
    public ExamTypeDTO create(ExamTypeDTO examTypeDTO) {
        ExamType examType = examTypeMapper.examTypeDTOtoExamType(examTypeDTO);
        ExamType save = examTypeRepository.save(examType);
        return examTypeMapper.examTypeToExamTypeDTO(save);

    }

    @Override
    public ExamTypeDTO update(Long id, ExamTypeDTO examTypeDTO) {
        boolean b = examTypeRepository.existsById(id);
        if(b){
            ExamType oldbyId = examTypeRepository.findById(id).orElse(null);
            ExamTypeDTO byId = examTypeMapper.examTypeToExamTypeDTO(oldbyId);
            byId.setType(examTypeDTO.getType());
            byId.setDescription(examTypeDTO.getDescription());
            byId.setExamIds(examTypeDTO.getExamIds());
            ExamType examType = examTypeMapper.examTypeDTOtoExamType(byId);
            ExamType save = examTypeRepository.save(examType);
            return examTypeMapper.examTypeToExamTypeDTO(save);
        }

        return null;
    }

    @Override
    public List<ExamTypeDTO> findAll() {
        return examTypeRepository.findAll().stream()
                .map(examTypeMapper::examTypeToExamTypeDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        examTypeRepository.deleteById(id);
    }

    @Override
    public ExamTypeDTO getById(Long id) {
        return examTypeMapper.examTypeToExamTypeDTO(examTypeRepository.findById(id).orElse(null));
    }
}
