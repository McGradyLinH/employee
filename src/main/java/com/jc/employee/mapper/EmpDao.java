package com.jc.employee.mapper;

import com.jc.employee.domain.Employee;
import com.jc.employee.domain.VacationDetail;

import java.util.List;

/**
 * @author LX
 * @date 2021/3/18
 */
public interface EmpDao {
    Employee queryUserByEmpCode(String empCode);

    List<Employee> queryAllEmp();
}
