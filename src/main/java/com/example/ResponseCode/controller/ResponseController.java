package com.example.ResponseCode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResponseController {

    @GetMapping("/ok")
    public ResponseEntity<String> okstatus(){
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @GetMapping("/requesttimeout")
    public ResponseEntity<String> requesttimeoutstatus(){
        return new ResponseEntity<String>(HttpStatus.REQUEST_TIMEOUT);
    }
    @GetMapping("/methodnotallowed")
    public ResponseEntity<String> methodnotallowedstatus(){
        return new ResponseEntity<String>(HttpStatus.METHOD_NOT_ALLOWED);
    }
    @GetMapping("/unauthorized")
    public ResponseEntity<String> unauthorizedstatus(){
        return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
    }
    @GetMapping("/badrequest")
    public ResponseEntity<String> badgatewaystatus(){
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

}
