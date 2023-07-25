package com.exammanagament.service.impl;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.entity.Exam;
import com.exammanagament.map.ExamMapper;
import com.exammanagament.repository.ExamRepository;
import com.exammanagament.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    private final ExamRepository repository;
    private final ExamMapper mapper;
    @Override
    public ExamDTO creat(ExamDTO examDTO) {
        return mapper.examToExamDTO(repository.save(mapper.examDTOtoExam(examDTO)));
    }

    @Override
    public ExamDTO findById(Long id) {
        return mapper.examToExamDTO(repository.findById(id).orElse(null));
    }

    @Override
    public List<ExamDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::examToExamDTO)
                .toList();
    }

    @Override
    public ExamDTO updateById(Long id, ExamDTO examDTO) {
        ExamDTO old = mapper.examToExamDTO(repository.findById(id).orElse(null));
        old.setAdminId(examDTO.getAdminId());
        old.setExamTypeId(examDTO.getExamTypeId());
        old.setStartDate(examDTO.getStartDate());
        old.setExamName(examDTO.getExamName());
        old.setExamQuestionIds(examDTO.getExamQuestionIds());
        old.setExamStudentIds(examDTO.getExamStudentIds());
        return mapper.examToExamDTO(repository.save(mapper.examDTOtoExam(old)));
    }

    @Override
    public String deleteById(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return id+" -li silindi";
        }
        else {return id+" -li tapilmadi";}
    }
}