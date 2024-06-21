package com.ohgiraffers.service;

import com.ohgiraffers.dto.EmployeeDTO;
import com.ohgiraffers.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class EmployeeService {

    // 이건 왜 만드는 것인가?
    private EmployeeMapper employeeMapper;

    public List<EmployeeDTO> selectAllEmployee() {

        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> employeeList = employeeMapper.selectAllEmployee();

        sqlSession.close();

        return employeeList;

    }

    public EmployeeDTO selectEmpByCode(int code) {

        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        EmployeeDTO employee = employeeMapper.selectEmpByCode(code);

        sqlSession.close();

        return employee;
    }

    public EmployeeDTO selectEmpByName(String name) {

        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        EmployeeDTO employee = employeeMapper.selectEmpByName(name);

        sqlSession.close();

        return employee;



    }

    public boolean registEmployee(EmployeeDTO employee) {
        SqlSession sqlSession = getSqlSession();

        System.out.println(employee);
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.insertEmployee(employee);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyEmployee(EmployeeDTO employee) {

        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.modifyEmployee(employee);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteEmployee(int code) {

        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.deleteEmployee(code);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
