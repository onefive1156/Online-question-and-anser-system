package com.felix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("hello/{userId}")
    public String test(@PathVariable String userId){
        System.out.println(userId);
        return "Hello springboot";
    }

//    @GetMapping("")

}
