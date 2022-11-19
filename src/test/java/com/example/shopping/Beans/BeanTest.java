package com.example.shopping.Beans;

import com.example.shopping.AppConfig;
import com.example.shopping.member.MemberService;
import com.example.shopping.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("등록된 빈 조회하기")
    void searchBeans(){

        String [] beanName = applicationContext.getBeanDefinitionNames();

        for (String beanDefinition : beanName) {
            Object bean=applicationContext.getBean(beanDefinition);
            System.out.println("beanName: "+ beanDefinition + ", beanOject : "+bean);
        }
    }

    @Test
    @DisplayName("이름으로 빈 조회하기")
    void searchBeansByName(){

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("타입으로 빈 조회하기")
    void searchBeansByType(){

        MemberService memberService = applicationContext.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }


    @Test
    @DisplayName("구체타입으로 빈 조회하기")
    void searchBeansByImpl(){

        MemberServiceImpl memberService = applicationContext.getBean("memberService",MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("미등록된 빈 조회하기")
    void searchBeanNotExist(){

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () ->  applicationContext.getBean("없는 빈조회", MemberService.class));
    }
}
