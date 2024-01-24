package com.example.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @RequestMapping("/hello")
    public String sayHello()
    {
        Logger logger = LoggerFactory.getLogger(HelloController.class);
        logger.info("Hello info level");
        return "hello";
    }
}
