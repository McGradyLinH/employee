package com.jc.employee.domain;

import lombok.Data;

/**
 * @author LX
 * @date 2021/3/18
 */
@Data
public class Employee {
    private int id;
    private String empName;
    private String empCode;
    private String deptName;
    private Employee leader;
    private String pwd;
}
