package com.validation.controller;


import com.validation.model.ValidationModel;
import com.validation.repository.ValidationRepository;
import com.validation.service.ValidationService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ValidationController {


    @Autowired
    ValidationRepository validationRepository;

    @PostMapping("/add")
    public ValidationModel test1(@Valid @RequestBody ValidationModel validationModel) throws ValidationException {
        return validationRepository.save(validationModel);
    }
}
