package com.jc.employee.test;

import com.jc.employee.domain.Employee;
import com.jc.employee.mapper.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author LX
 * @date 2021/5/10
 */
public class Test2 {

    public static void main(String[] args) {
        try {
            InputStream is = Resources.getResourceAsStream("mapper/emp.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            List<Employee> employees = mapper.queryAllEmp();
            System.out.println(employees.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
