package com.ohgiraffers.common;

// lombok은 실행할 때 내가 만들어놓은 필드대로 생성자와 게터 세터를 만들어줌.
import lombok.*;

// 기본생성자
@NoArgsConstructor

// 모든 필드를 초기화하는 생성자
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuDTO {

    private int code;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;

}
