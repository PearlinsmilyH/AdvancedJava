package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/home")
    public String home(){
        String Product = restTemplate.getForObject("http://localhost:8082/product",String.class);
        return Product;
    }
}
