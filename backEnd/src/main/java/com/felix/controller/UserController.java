package com.felix.controller;

import com.felix.domain.Student;
import com.felix.service.StudentService;
import com.felix.service.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> userLogin(@PathVariable String userId){
        System.out.println(userId);
        System.out.println(studentService.selectStudentByWXId(userId));
        Student temp = studentService.selectStudentByWXId(userId);
        if(temp != null){
            return new ResponseEntity<>(temp, HttpStatus.OK);
        }else{
            Student student = new Student();
            student.setWeixinId(userId);
            studentService.insertStudent(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }
    
    @PutMapping
    public ResponseEntity<Student> user(@RequestBody Student student){
        System.out.println(student);
        return new ResponseEntity<>(new Student(), HttpStatus.OK);
    }

}
