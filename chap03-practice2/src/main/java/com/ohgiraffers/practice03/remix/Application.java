package com.ohgiraffers.practice03.remix;

import com.ohgiraffers.controller.EmployeeController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    /*
     * 시스템 요구사항
     * 1. 모든 직원 조회
     * 2. 직원 번호로 직원 조회
     * 3. 직원 이름으로 조회
     * 4. 직원 추가
     * 5. 직원 수정
     * 6. 직원 삭제
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 컨트롤러에 있는 메소드를 사용하게 위해서 쓴 것!
        EmployeeController employeeController = new EmployeeController();

        do {
            System.out.println("=============== 오지라퍼 메뉴 관리 시스템 ===============");
            System.out.println("1. 모든 직원 조회하기");
            System.out.println("2. 직원 번호로 직원 조회하기");
            System.out.println("3. 직원 이름으로 조회하기");
            System.out.println("4. 신규 직원 추가하기");
            System.out.println("5. 직원 수정하기");
            System.out.println("6. 직원 삭제하기");
            System.out.println("원하는 직원 관리 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            // 1. 여기서 이름을 지정해서 만들어
            switch (no) {
                case 1 : employeeController.selectAllEmployee(); break;
                case 2 : employeeController.selectEmpByCode(inputEmployeeCode()); break;
                case 3 : employeeController.selectEmpByName(inputEmployeeName()); break;
                case 4 : employeeController.registEmployee(registEmployee()); break;
                case 5 : employeeController.modifyEmployee(inputModifyEmployee()); break;
                case 6 : employeeController.seleteEmployee(inputEmployeeCode()); break;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        } while (true);
    }


    // EmployeeCode를 입력받는 메소드
    private static Map<String, String> inputEmployeeCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("직원 번호를 입력하세요 : ");
        String code = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;

    }

    // EmployeeName을 입력받는 메소드

    private static Map<String, String> inputEmployeeName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("직원 이름을 입력하세요 : ");
        String name = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);

        return parameter;

    }

    // 신규 직원 등록을 위한 정보를 입력받는 메소드
    private static Map<String, String> registEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("직원 아이디를 입력하세요 : ");
        String empId = sc.nextLine();

        System.out.println("직원 이름을 입력하세요 : ");
        String empName = sc.nextLine();

        System.out.println("직원 주민번호를 입력하세요 : ");
        String empNo = sc.nextLine();

        System.out.println("직원 직급 코드를 입력하세요 : ");
        String jobCode = sc.nextLine();

        System.out.println("직원 월급 레벨을 입력하세요 : ");
        String salLevel = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);
        parameter.put("empName", empName);
        parameter.put("empNo", empNo);
        parameter.put("jobCode", jobCode);
        parameter.put("salLevel", salLevel);

        return parameter;

    }

    // 수정할 직원 정보를 입력받는 메소드
    private static Map<String, String> inputModifyEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.println("수정할 직원 아이디를 입력하세요 : ");
        String empId = sc.nextLine();

        System.out.println("수정할 직원 이름을 입력하세요 : ");
        String empName = sc.nextLine();

        System.out.println("수정할 직원 주민번호를 입력하세요 : ");
        String empNo = sc.nextLine();

        System.out.println("수정할 직원 직급 코드를 입력하세요 : ");
        String jobCode = sc.nextLine();

        System.out.println("수정할 직원 월급 레벨을 입력하세요 : ");
        String salLevel = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);
        parameter.put("empName", empName);
        parameter.put("empNo", empNo);
        parameter.put("jobCode", jobCode);
        parameter.put("salLevel", salLevel);

        return parameter;

    }


}
