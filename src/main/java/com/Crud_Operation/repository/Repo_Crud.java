package com.Crud_Operation.repository;

import com.Crud_Operation.model.Model_Crud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface Repo_Crud  extends JpaRepository<Model_Crud,Integer> {
    Optional<Model_Crud> findByName(String gggg);
}

