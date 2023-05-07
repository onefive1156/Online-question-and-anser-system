package com.felix;

import com.felix.domain.Student;
import com.felix.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BackEndApplicationTests {
	@Resource
	StudentMapper studentMapper;
	@Test
	void contextLoads() {
		System.out.println(studentMapper.selectStudentByWXId("123"));
	}

}
