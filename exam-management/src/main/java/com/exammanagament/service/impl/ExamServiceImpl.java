package com.exammanagament.service.impl;

import com.exammanagament.dto.ExamDTO;
import com.exammanagament.entity.Exam;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.map.ExamMapper;
import com.exammanagament.repository.ExamRepository;
import com.exammanagament.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    private final ExamRepository repository;
    private final ExamMapper mapper;

    @Override
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void create(ExamDTO examDTO) {
        Exam exam = mapper.examDTOtoExam(examDTO);
        try {
            repository.save(exam);
        } catch (Exception ex) {

            throw new RuntimeException("Imtahan əlavə etmək mümkün olmadı.");

        }

    }

    @Override
    public ExamDTO findById(Long id) {
        Exam exam = repository.findById(id).orElseThrow(() -> new NotFoundException("Bu id-li imtahan tapılmadı: " + id));
        return mapper.examToExamDTO(exam);
    }

    @Override
    public List<ExamDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::examToExamDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void updateById(Long id, ExamDTO examDTO) throws NotFoundException {
        Exam exam = repository.findById(id).orElseThrow(() -> new NotFoundException("Belə bir imtahan cədvəli tapılmadı :( "));

        mapper.updateExamFromDTO(examDTO, exam);
        exam.setExamType(mapper.mapLongToExamType(examDTO.getExamTypeId()));


        try {

            repository.save(exam);
        } catch (Exception ex) {
            throw new RuntimeException("Imtahanı yeniləmək mümkün olmadı : " + id, ex);
        }


    }


    @Override
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public void deleteById(Long id) {
        if (repository.existsById(id)) {

            try {

                repository.deleteById(id);
            } catch (RuntimeException ex) {
                throw new RuntimeException("Imtahanı silmək mümkün olmadı : " + id, ex);
            }
        } else throw new NotFoundException("Bu id-li Imtahan tapılmadı: " + id);

    }


}