package com.ohgiraffers.practice03.remix;

import java.util.List;
import java.util.Map;

public class EmployeeController {

    private final PrintResult printResult;
    private final EmployeeService employeeService;

    // 생성자 주입
    public EmployeeController() {
        printResult = new PrintResult();
        employeeService = new EmployeeService();
    }

    // 전체조회
    public void selectAllEmployee() {

        List<EmployeeDTO> employeeList = employeeService.selectAllEmployee();

        if (employeeList != null) {
            printResult.printEmployeeList(employeeList);
        } else {
            printResult.printErrorMessage("selectList");
        }

    }

    // 직원 코드로 직원 조회
    public void selectEmpByCode(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        EmployeeDTO employee = employeeService.selectEmpByCode(code);

        if (employee != null) {
            printResult.printEmployee(employee);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    // 직원 이름으로 직원 조회
    public void selectEmpByName(Map<String, String> parameter) {

        String name = parameter.get("name");

        EmployeeDTO employee = employeeService.selectEmpByName(name);

        if (employee != null) {
            printResult.printEmployee(employee);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registEmployee(Map<String, String> parameter) {
        String empId = parameter.get("empId");
        String empName = parameter.get("empName");
        String empNo = parameter.get("empNo");
        String jobCode = parameter.get("jobCode");
        String salLevel = parameter.get("salLevel");

        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setEmpNo(empNo);
        employee.setJobCode(jobCode);
        employee.setSalLevel(salLevel);

        if (employeeService.registEmployee(employee)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }



    }

    // 직원 수정
    public void modifyEmployee(Map<String, String> parameter) {

        String empId = parameter.get("empId");
        String empName = parameter.get("empName");
        String empNo = parameter.get("empNo");
        String jobCode = parameter.get("jobCode");
        String salLevel = parameter.get("salLevel");

        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setEmpNo(empNo);
        employee.setJobCode(jobCode);
        employee.setSalLevel(salLevel);

        if (employeeService.modifyEmployee(employee)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }

    }


    public void seleteEmployee(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        if (employeeService.deleteEmployee(code)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
