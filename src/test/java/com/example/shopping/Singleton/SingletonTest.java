package com.example.shopping.Singleton;

import com.example.shopping.AppConfig;
import com.example.shopping.order.Order;
import com.example.shopping.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {



    @Test
    @DisplayName("자바코드에서 요청객체 생성")
    void NotSingletonTest(){
        AppConfig appConfig = new AppConfig();

        OrderService orderService1 = appConfig.orderService();
        OrderService orderService2 = appConfig.orderService();

        System.out.println( orderService1 + " : "+orderService2);
        Assertions.assertThat(orderService1).isNotEqualTo(orderService2);

    }

    @Test
    @DisplayName("싱글톤 생성코드")
    void makeSingleton(){
        SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();
        System.out.println(singleTon1+" : "+singleTon2);
        Assertions.assertThat(singleTon1).isSameAs(singleTon2);
    }

    @Test
    @DisplayName("스프링 싱글톤")
    void springContainerSingleton(){
        //스프링 컨테이너
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService1 = ac.getBean(OrderService.class);
        OrderService orderService2 = ac.getBean(OrderService.class);

        System.out.println(orderService1 + " : "+orderService2);
        Assertions.assertThat(orderService1).isSameAs(orderService2);
    }


}
