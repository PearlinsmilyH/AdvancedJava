package com.example.params.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class Controllerparam
{
    //@RequestParam allow you to directly access and extract individual
    //request parameters without having to handle the entire request body
    @GetMapping("/request")
    public String getUsers(@RequestParam String name, @RequestParam(defaultValue = "25") int age)
    {
        return "My name is "+name+". I am "+age+" year's old";
    }
    //@RequestHeaders are used to transmit additional information
    //between the client and server in an HTTP request and response
    @GetMapping("/header")
    public String handleRequestHeader(@RequestHeader String authorization)
    {
        System.out.println("Printing the header "+authorization);
        return "Success";
    }
}
