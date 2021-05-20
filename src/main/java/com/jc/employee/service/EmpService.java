package com.jc.employee.service;

import com.jc.employee.domain.Employee;
import com.jc.employee.domain.VacationDetail;

import java.util.List;

/**
 * @author LX
 * @date 2021/3/18
 */
public interface EmpService {
    /**
     * 通过员工编号查询员工信息
     * @param employee
     * @return
     */
    Employee queryUserByEmpCode(Employee employee);

    /**
     * 查询所有人员
     * @return
     */
    List<Employee> queryAllEmp();
}
