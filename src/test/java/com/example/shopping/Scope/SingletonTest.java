package com.example.shopping.Scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {
    @Test
    @DisplayName("싱글톤 빈 테스트")
    void singleTonBeanTest(){
        //new AnnotationConfigApplicationContext(SingletonBean.class)하면 자동으로 CompoenetScan이 된다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2= ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 : "+singletonBean1);
        System.out.println("singletonBean2 : "+singletonBean2);

        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);
        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init()");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destroy()");
        }
    }
}
