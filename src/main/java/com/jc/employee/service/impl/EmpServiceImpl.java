package com.jc.employee.service.impl;

import com.jc.employee.domain.Employee;
import com.jc.employee.domain.VacationDetail;
import com.jc.employee.mapper.EmpDao;
import com.jc.employee.service.EmpService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LX
 * @date 2021/3/18
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    EmpDao empDao;

    /**
     * 通过员工编号查询员工信息
     * @param employee
     * @return
     */
    @Override
    public Employee queryUserByEmpCode(Employee employee) {
        Employee resultEmp = empDao.queryUserByEmpCode(employee.getEmpCode());
        if (null != resultEmp && resultEmp.getPwd().equals(employee.getPwd())){
            return resultEmp;
        }
        return null;
    }

    @Cacheable(value = "employees")
    @Override
    public List<Employee> queryAllEmp() {
        return empDao.queryAllEmp();
    }
}
