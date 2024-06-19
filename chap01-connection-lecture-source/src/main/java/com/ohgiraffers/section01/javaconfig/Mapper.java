package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Mapper {


    // 쿼리문이 여기에 담기는 것
//    @Select("/* 쿼리문 작성 위치 */")
//    @Update()
//    @Delete()
//    @Insert()

    @Select("select curdate()")
    java.util.Date selectSysdate();
    // Date가 타입으로 selectSysdate로 반환됨, @Select 쿼리문 실행


}
