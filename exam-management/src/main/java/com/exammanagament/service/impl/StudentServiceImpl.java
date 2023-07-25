package com.exammanagament.service.impl;

import com.exammanagament.dto.StudentDto;
import com.exammanagament.entity.Student;
import com.exammanagament.map.StudentMap;
import com.exammanagament.repository.StudentRepository;
import com.exammanagament.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
private final StudentRepository repository;
private final StudentMap studentMap;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        return studentMap.mapToStudentDto(repository.save(studentMap.mapToStudent(studentDto))) ;
    }

    @Override
    public List<StudentDto> readAllStudents() {
        return repository.findAll().stream()
                .map(studentMap::mapToStudentDto)
                .toList();
    }

    @Override
    public StudentDto updateStudentGetById(Long id, StudentDto studentDto) {
        Student oldStudent=repository.findById(id).orElse(null);
        if (oldStudent != null){
            studentDto.setEmail(studentDto.getEmail());
            studentDto.setBirth_date(studentDto.getBirth_date());
            studentDto.setPhone_number(studentDto.getPhone_number());
            studentDto.setStatus(studentDto.getStatus());
            studentDto.setName(studentDto.getName());
            studentDto.setSurname(studentDto.getSurname());
            return studentMap.mapToStudentDto(repository.save(studentMap.mapToStudent(studentDto)));
        }else {
            return null;
        }

    }

    @Override
    public String deleteStudentGetById(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "silindi";
        }else {
            return "bele bir id-li student tapilmadi";
        }
    }

    @Override
    public StudentDto studentGetById(Long id) {
        return studentMap.mapToStudentDto(repository.findById(id).orElse(null));
    }
}
