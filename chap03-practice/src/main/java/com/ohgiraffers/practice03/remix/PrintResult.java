package com.ohgiraffers.practice03.remix;

import java.util.List;

public class PrintResult {

    public void printEmployeeList(List<EmployeeDTO> employeeList) {

        for (EmployeeDTO employeeDTO : employeeList) {
            System.out.println(employeeDTO);
        }
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "직원 조회를 실패했습니다."; break;
            case "selectOne" : errorMessage = "직원 목록 조회를 실패했습니다."; break;
            case "insert" : errorMessage = "신규 직원 등록을 실패했습니다."; break;
            case "update" : errorMessage = "직원 수정을 실패했습니다."; break;
            case "delete" : errorMessage = "직원 삭제를 실패했습니다."; break;

        }
        System.out.println(errorMessage);

    }

    public void printEmployee(EmployeeDTO employee) {
        System.out.println(employee);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode) {
            case "insert" : successMessage = "신규 직원 등록을 성공했습니다."; break;
            case "update" : successMessage = "직원 수정을 성공했습니다."; break;
            case "delete" : successMessage = "직원 삭제를 성공했습니다."; break;

        }
        System.out.println(successMessage);
    }




}
