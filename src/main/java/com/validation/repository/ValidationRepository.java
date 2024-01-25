package com.validation.repository;

import com.validation.model.ValidationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<ValidationModel,Integer> {

}
