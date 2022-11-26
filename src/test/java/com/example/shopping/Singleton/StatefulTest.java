package com.example.shopping.Singleton;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulTest {

    @Test
    @DisplayName("싱글톤의 객체 인스턴스 공유 문제점")
    void SingletonStatefulTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        SingletonStateful singletonStateful1 = ac.getBean(SingletonStateful.class);
        SingletonStateful singletonStateful2 = ac.getBean(SingletonStateful.class);

        singletonStateful1.editAge("손흥민",31);
        singletonStateful2.editAge("김민재",28);

        System.out.println("손흥민 나이: "+singletonStateful1.getAge());
        System.out.println("김민재 나이: "+singletonStateful2.getAge());
    }

    @Test
    @DisplayName("싱글톤 unStateful설계")
    void SingletonStatefulTestByUnstateful(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        SingletonStateful singletonStateful1 = ac.getBean(SingletonStateful.class);
        SingletonStateful singletonStateful2 = ac.getBean(SingletonStateful.class);

        int SonAge = singletonStateful1.editAgeByUnstateful("손흥민",31);
        int KimAge = singletonStateful2.editAgeByUnstateful("김민재",28);

        System.out.println("손흥민 나이: "+SonAge);
        System.out.println("김민재 나이: "+KimAge);
    }

    public static class TestConfig{
        @Bean
        public  SingletonStateful singletonStateful(){
            return new SingletonStateful();
        }
    }
}
