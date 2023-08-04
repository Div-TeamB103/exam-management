package com.exammanagament.service.impl;

import com.exammanagament.dto.StudentDto;
import com.exammanagament.entity.Student;
import com.exammanagament.exception.NotFoundException;
import com.exammanagament.map.StudentMap;
import com.exammanagament.repository.StudentRepository;
import com.exammanagament.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentMap studentMap;

    @Override
    @Transactional
    public void createStudent(StudentDto studentDto) {
        Student student = studentMap.mapToStudent(studentDto);
        repository.save(student);
    }

    @Override
    public List<StudentDto> readAllStudents() {
        return repository.findAll().stream()
                .map(studentMap::mapToStudentDto)
                .toList();
    }

    @Override
    @Transactional(rollbackFor = {SQLException.class , RuntimeException.class})
    public void updateStudentGetById(Long id, StudentDto studentDto) {
        Student student = repository.findById(id).orElseThrow(() -> new NotFoundException("Bu idli student tapilmadi: " + id));
        studentMap.updateStudentFromDTO(studentDto, student);
        repository.save(student);
    }

    @Override
    @Transactional(rollbackFor = {SQLException.class , RuntimeException.class })
    public void deleteStudentGetById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

        }else throw new NotFoundException("Bu idli student tapılmadı: "+id);


    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = repository.findById(id).orElseThrow(() -> new NotFoundException("Bu idli user yoxdur: " + id));
        return studentMap.mapToStudentDto(student);
    }
}
