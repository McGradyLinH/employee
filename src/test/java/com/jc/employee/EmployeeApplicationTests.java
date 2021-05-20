package com.jc.employee;

import com.jc.employee.domain.Employee;
import com.jc.employee.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeApplicationTests {
    @Autowired
    EmpService empService;

    @Test
    void contextLoads() {
        Employee employee = new Employee();
        employee.setEmpCode("1001");
        employee.setPwd("123");
        Employee employee1 = empService.queryUserByEmpCode(employee);
        System.out.println(employee1);
    }

}
