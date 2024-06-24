package com.ohgiraffers.practice.emp;

import com.ohgiraffers.common.DepartmentAndEmployeeDTO;
import com.ohgiraffers.common.DepartmentDTO;
import com.ohgiraffers.common.EmployeeAndDepartmentDTO;
import com.ohgiraffers.common.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementTestService {

    private ElementTestMapper mapper;

    public void selectResultMapAssociationTest() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<EmployeeAndDepartmentDTO> employeeList = mapper.selectResultMapAssociationTest();

        for (EmployeeAndDepartmentDTO employee : employeeList) {
//            System.out.println("사원 이름 : " + employee.getEmpName() + " | 부서명 : " + employee.getDepartment().getDeptTitle());
            System.out.println(employee);
        }

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<DepartmentAndEmployeeDTO> deptList = mapper.selectResultMapCollectionTest();

//        for (DepartmentAndEmployeeDTO dept : deptList) {
//            System.out.println(dept);
//        }

        List<EmployeeDTO> empList = deptList.get(1).getEmployeeList();

        for (EmployeeDTO emp : empList) {
            System.out.println(emp);
        }

        sqlSession.close();

    }
}
