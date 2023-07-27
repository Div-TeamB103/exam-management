package com.exammanagament.service.impl;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.exception.UserNotFoundExcemtion;
import com.exammanagament.map.ExamMapper;
import com.exammanagament.repository.ExamRepository;
import com.exammanagament.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ExamDTO updateById(Long id, ExamDTO examDTO) throws UserNotFoundExcemtion {
        ExamDTO old = mapper.examToExamDTO(repository.findById(id).orElse(null));
        if (old!=null){
        old.setAdminId(examDTO.getAdminId());
        old.setExamTypeId(examDTO.getExamTypeId());
        old.setStartDate(examDTO.getStartDate());
        old.setExamName(examDTO.getExamName());
        old.setExamQuestionIds(examDTO.getExamQuestionIds());
        old.setExamStudentIds(examDTO.getExamStudentIds());
        return mapper.examToExamDTO(repository.save(mapper.examDTOtoExam(old)));}
        throw new UserNotFoundExcemtion("Could not find any users with id");
    }

    @Override
    public String deleteById(Long id) throws UserNotFoundExcemtion {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
        throw new UserNotFoundExcemtion("Could not find any users with id");
    }
}