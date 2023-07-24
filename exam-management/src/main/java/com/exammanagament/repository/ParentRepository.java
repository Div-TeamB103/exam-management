package com.exammanagament.repository;

import com.exammanagament.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository  extends JpaRepository<Parent , Long> {

    Optional<Parent> findByEmail(String email);
    Optional<Parent> findById(Long id);



}
