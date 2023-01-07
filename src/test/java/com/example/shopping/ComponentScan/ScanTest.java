package com.example.shopping.ComponentScan;

import com.example.shopping.AutoAppConfig;
import com.example.shopping.order.OrderService;
import com.example.shopping.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScanTest {

    @Test
    @DisplayName("AutoAppConfig 테스트")
    void ScanTest(){
        AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AutoAppConfig.class);
        OrderService orderService = ac.getBean(OrderService.class);

        Assertions.assertThat(orderService).isInstanceOf(OrderService.class);
    }


}
