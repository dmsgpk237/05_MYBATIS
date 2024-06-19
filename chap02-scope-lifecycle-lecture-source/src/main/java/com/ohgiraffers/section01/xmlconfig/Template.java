package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    /*
    * SqlSessionFactory 는 어플리케이션이 실행하는 동안 존재해야 하며
    * 어플리케이션이 실행되는 동안 여러 차례 SqlSessionFactory를 다시 빌드하지 않는 것이 좋은 형태다.
    * 따라서, 어플리케이션 스코프를 관리하기 위한 가장 간단한 방법인 싱글톤 패턴을 사용해서 관리한다.
    * */

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        /*
        * SqlSessionFactoryBuilder는 SqlSession을 생성한 후에 유지 할 필요가 없다.
        * 따라서, 메소드 스코프로 만든다.
        * */

        // 메소드, 어플리케이션 스코프?
        /*
        * 팩토리 빌더는 메소드가 끝나면 사라지게 하는 거다. 어플리케이션 스코프는
        * 어플리케이션이 실행되는 동안에만 살아있고, 어플리케이션이 끝나면 사라지는 스코프다.
        * */

        if (sqlSessionFactory == null) {

            String resource = "mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println("sqlSessionFactory의 hashConde() : " + sqlSessionFactory.hashCode());
        System.out.println("sqlSession의 hashConde() : " + sqlSession.hashCode());
        return sqlSession;

    }
}
