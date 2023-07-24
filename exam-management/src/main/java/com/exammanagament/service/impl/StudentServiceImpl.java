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
        Student oldStudent1=repository.findById(id).orElse(null);
        StudentDto oldStudent = studentMap.mapToStudentDto(oldStudent1);
        if (oldStudent != null){
            oldStudent.setEmail(studentDto.getEmail());
            oldStudent.setBirth_date(studentDto.getBirth_date());
            oldStudent.setPhone_number(studentDto.getPhone_number());
            oldStudent.setStatus(studentDto.getStatus());
            oldStudent.setName(studentDto.getName());
            oldStudent.setSurname(studentDto.getSurname());

            return studentMap.mapToStudentDto(repository.save(studentMap.mapToStudent(oldStudent)));
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
