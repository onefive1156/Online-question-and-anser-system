package com.felix.domain;

import lombok.Data;
import sun.rmi.runtime.Log;

@Data
public class Student
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String grade;
    private String major;
    private String age;
    private String sex;
    private String introduce;
    private Long delFlag;
    private Long weixinId;
}