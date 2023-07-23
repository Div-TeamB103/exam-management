package com.exammanagament.repository;

import com.exammanagament.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {


}
