package com.home_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/Home")
    public String home(){
        String Product = restTemplate.getForObject("http://localhost:8082/products",String.class);
        return Product;
    }
}
