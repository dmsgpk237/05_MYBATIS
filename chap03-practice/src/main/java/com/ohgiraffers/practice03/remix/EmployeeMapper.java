package com.ohgiraffers.practice03.remix;

import java.util.List;

public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployee();

    EmployeeDTO selectEmpByCode(int code);

    EmployeeDTO selectEmpByName(String name);

    int insertEmployee(EmployeeDTO employee);

    int modifyEmployee(EmployeeDTO employee);

    int deleteEmployee(int code);
}
