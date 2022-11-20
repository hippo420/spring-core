package com.example.shopping.Beans;

import com.example.shopping.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 메타정보 확인하기")
    void SearchBeanDefinition(){
        String [] beanDefinitionName = applicationContext.getBeanDefinitionNames();

        for (String bean : beanDefinitionName) {
            System.out.println("beanDefinition=> "+bean );
        }
    }
}
