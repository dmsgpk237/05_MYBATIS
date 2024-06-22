package com.ohgiraffers.practice03.remix;

import com.ohgiraffers.controller.JobController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application2 {

    /*
     * 시스템 요구사항
     * 1. 모든 직급 조회
     * 2. 직급 코드로 직급 이름 조회
     * 3. 직급 이름으로 직급 코드 조회
     * 4. 직급 추가
     * 5. 직급 수정
     * 6. 직급 삭제
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 컨트롤러에 있는 메소드를 사용하게 위해서 쓴 것!
        JobController jobController = new JobController();

        do {
            System.out.println("=============== 오지라퍼 메뉴 관리 시스템 ===============");
            System.out.println("1. 모든 직급 조회하기");
            System.out.println("2. 직급 코드로 직급 이름 조회하기");
            System.out.println("3. 직급 이름으로 직급 코드 조회하기");
            System.out.println("4. 직급 추가하기");
            System.out.println("5. 직급 수정하기");
            System.out.println("6. 직급 삭제하기");
            System.out.println("9. 프로그램 종료하기");
            System.out.println("원하는 직급 관리 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            // 1. 여기서 이름을 지정해서 만들어
            switch (no) {
                case 1 : jobController.selectAllJob(); break;
                case 2 : jobController.selectJobByCode(inputJobCode()); break;
                case 3 : jobController.selectJobByName(inputJobName()); break;
//                case 4 :  break;
//                case 5 :  break;
//                case 6 :  break;
                case 9 :
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 번호를 선택하셨습니다.");
                    break;
            }
        } while (true);
    }

    private static Map<String, String> inputJobCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("직급 코드를 입력하세요 : ");
        String code = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

    private static Map<String, String> inputJobName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("직급 이름을 입력하세요 : ");
        String name = sc.next();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);

        return parameter;

    }

}
