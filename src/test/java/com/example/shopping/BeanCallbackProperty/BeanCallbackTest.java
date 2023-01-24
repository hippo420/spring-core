package com.example.shopping.BeanCallbackProperty;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanCallbackTest {

    @Test
    @DisplayName("빈 콜백 설정정보")
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(BeanCallback.class);
        DatabaseClient databaseClient = ac.getBean(DatabaseClient.class);
        ac.close();
    }

    @Configuration
    static class BeanCallback{

        @Bean(initMethod = "init",destroyMethod = "close")
        public DatabaseClient databaseClient(){
            DatabaseClient database = new DatabaseClient();
            database.setUrl("http://DBProperties....");
            return database;
        }
    }

}
