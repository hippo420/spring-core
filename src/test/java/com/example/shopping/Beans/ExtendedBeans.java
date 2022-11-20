package com.example.shopping.Beans;

import com.example.shopping.point.CrazyPointPolicy;
import com.example.shopping.point.NonCrazyPointPolicy;
import com.example.shopping.point.PointPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ExtendedBeans {

    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Configuration
    static class TestConfig{

        @Bean
        public PointPolicy NonCrazyPointPolicy(){
            return new NonCrazyPointPolicy();
        }

        @Bean
        public PointPolicy CrazyPointPolicy(){
            return new CrazyPointPolicy();
        }
    }


    @Test
    @DisplayName("부모로 조회시 => NoUniqueBeanDefinitionException ")
    void BeanByParent(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, ()->ac.getBean(PointPolicy.class));
    }

    @Test
    @DisplayName("부모타입으로 모두 조회")
    void BeanByParentType(){
        Map<String,PointPolicy> bean = ac.getBeansOfType(PointPolicy.class);
        org.assertj.core.api.Assertions.assertThat(bean.size()).isEqualTo(2);

        for (String key : bean.keySet()) {
            System.out.println("key: "+key +", value: "+bean.get(key));
        }
    }

    @Test
    @DisplayName("하위 타입으로 조회")
    void BeanByChild(){
        NonCrazyPointPolicy bean = ac.getBean(NonCrazyPointPolicy.class);
        org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(NonCrazyPointPolicy.class);

    }

    @Test
    @DisplayName("Oject 타입으로 조회")
    void BeanByObject(){
        Map<String,Object> bean = ac.getBeansOfType(Object.class);

        for (String key : bean.keySet()) {
            System.out.println("key: "+key +", value: "+bean.get(key));
        }

    }
}
