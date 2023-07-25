package com.exammanagament.service.impl;

import com.exammanagament.dto.ExamTypeDTO;
import com.exammanagament.entity.ExamType;
import com.exammanagament.map.ExamTypeMapper;
import com.exammanagament.repository.ExamTypeRepository;
import com.exammanagament.service.ExamTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class ExamTypeImpl implements ExamTypeService {

    private final ExamTypeRepository examTypeRepository;

    private final ExamTypeMapper examTypeMapper;

    @Override
    public List<ExamTypeDTO> findAll() {
        return examTypeRepository.findAll().stream().map(examTypeMapper::examTypeToExamTypeDTO).toList();
    }

    @Override
    public ExamTypeDTO findById(Long id) {
        return examTypeMapper.examTypeToExamTypeDTO(examTypeRepository.findById(id).orElse(null));
    }

    @Override
    public ExamTypeDTO save(ExamTypeDTO examTypeDTO) {
        return examTypeMapper.examTypeToExamTypeDTO(examTypeRepository.save(examTypeMapper.examTypeDTOtoExamType(examTypeDTO)));
    }

    @Override
    public String delete(Long id) {
        if(examTypeRepository.existsById(id)){
            examTypeRepository.deleteById(id);
        }
        return "Silindi";
    }

    @Override
    public ExamTypeDTO update(Long id, ExamTypeDTO examTypeDTO) {
        ExamType oldExamType=examTypeRepository.findById(id).orElse(null);
        ExamTypeDTO oldExamType1=examTypeMapper.examTypeToExamTypeDTO(oldExamType);
        if(oldExamType1!=null){
            oldExamType1.setType(examTypeDTO.getType());
            oldExamType1.setExamIds(examTypeDTO.getExamIds());
            oldExamType1.setDescription(examTypeDTO.getDescription());
        }
        return examTypeMapper.examTypeToExamTypeDTO(examTypeRepository.save(examTypeMapper.examTypeDTOtoExamType(oldExamType1)));
    }


}
