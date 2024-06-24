package com.ohgiraffers.practice.emp;

import com.ohgiraffers.common.DepartmentAndEmployeeDTO;
import com.ohgiraffers.common.EmployeeAndDepartmentDTO;

import java.util.List;

public interface ElementTestMapper {
    List<EmployeeAndDepartmentDTO> selectResultMapAssociationTest();

    List<DepartmentAndEmployeeDTO> selectResultMapCollectionTest();

}
