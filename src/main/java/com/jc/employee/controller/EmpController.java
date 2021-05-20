package com.jc.employee.controller;

import com.jc.employee.domain.BaseResult;
import com.jc.employee.domain.Employee;
import com.jc.employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author LX
 * @date 2021/3/18
 */
@RestController
@RequestMapping("/emp")
public class EmpController {
    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping("/login")
    public BaseResult login(@RequestBody Employee employee) {
        Employee employee1 = empService.queryUserByEmpCode(employee);
        if (employee1 != null) {
            return new BaseResult(200, employee1);
        }
        return new BaseResult(404, "用户名或者密码错误！");
    }

    @GetMapping
    public List<Employee> employees() {
        return empService.queryAllEmp();
    }
}
