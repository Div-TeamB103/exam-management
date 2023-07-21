package com.exammanagament.repository;

import com.exammanagament.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findStudentByNameAndSurname(String name,String surname);
    Student findStudentByEmail(String email);

}
