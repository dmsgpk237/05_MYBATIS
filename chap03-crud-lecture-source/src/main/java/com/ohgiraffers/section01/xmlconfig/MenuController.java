package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {

    /*
    * Controller
    * 뷰와 모델 사이의 전달자 역할
    * 모델에게 명령을 전달해주는 역할로 모델의 상태를 변경할 수 있다.
    * 모델한테 응답을 받고서 뷰한테 명령을 보냄으로써 모델의 표시 방법을 바꿀 수 있다.
    *
    * Service 를 알고 있어야 한다.
    * 서비스가 명령을 받아서 처리를 해야하는 친구임.
    * */

    private final MenuService menuService;
    private final PrintResult printResult;

    // 생성자 주입
    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        // view로 전달
        if(menuList != null){
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByCode(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        // 코드를 int 형태로 받았으니까 받은 코드를 서비스로 보내기
        MenuDTO menu = menuService.selectMenuByCode(code);

        // view로 전달
        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }
}
