package com.example.shopping.Autowired;

import com.example.shopping.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {


    @Test
    @DisplayName("의존성자동 Option주입 테스트")
    void AutowiredOptionTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{


        @Autowired(required = false)
        public void noBean1(Member nobean1){
            System.out.println("nobean1 : "+nobean1);
        }

        @Autowired
        public void noBean2(@Nullable Member nobean2){
            System.out.println("nobean2 : "+nobean2);
        }

        @Autowired
        public void noBean3(Optional<Member> nobean3){
            System.out.println("nobean3 : "+nobean3);
        }

    }
}