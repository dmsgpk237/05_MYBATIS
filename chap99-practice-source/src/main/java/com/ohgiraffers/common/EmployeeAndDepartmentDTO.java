package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeAndDepartmentDTO {

    private String empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;

    private DepartmentDTO department;

    private String jobCode;
    private String salLevel;
    private double salary;
    private double bonus;
    private String managerId;
    private java.sql.Date hireDate;
    private java.sql.Date entDate;
    private String entYn;

}
