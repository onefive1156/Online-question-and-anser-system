package com.felix.controller;

import com.felix.domain.Student;
import com.felix.service.StudentService;
import com.felix.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Resource
    private StudentService studentService;
    @GetMapping("hello/{userId}")
    public String test(@PathVariable String userId){
        System.out.println(userId);
        return "Hello springboot";
    }

    @PostMapping("/login/{userId}")
    public String userLogin(@PathVariable String userId){
        System.out.println(userId);
        System.out.println(studentService.selectStudentList(new Student()));
        return "hello login";
    }

}
