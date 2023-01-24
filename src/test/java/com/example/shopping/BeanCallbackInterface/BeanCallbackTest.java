package com.example.shopping.BeanCallbackInterface;

import com.example.shopping.BeanCallbackProperty.DatabaseClient;
import com.example.shopping.LifeCycle.NetworkClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanCallbackTest {

    @Test
    @DisplayName("빈 콜백 인터페이스")
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(BeanCallback.class);
        DatabaseClient client = ac.getBean(DatabaseClient.class);
        ac.close();
    }

    @Configuration
    static class BeanCallback{

        @Bean
        public DatabaseClient database(){
            DatabaseClient database = new DatabaseClient();
            database.setUrl("http://DBProperties....");
            return database;
        }
    }

}
