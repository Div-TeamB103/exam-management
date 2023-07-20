package com.exammanagament.repository;

import com.exammanagament.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuestionRepository extends JpaRepository<Question ,Integer> {
    Question findByQuestionName(String name);




}
