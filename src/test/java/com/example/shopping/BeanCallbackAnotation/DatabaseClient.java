package com.example.shopping.BeanCallbackAnotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DatabaseClient {

    private String dbUrl;

    public DatabaseClient(){
        System.out.println("생성자 호출 Url : "+dbUrl);

    }

    public void setUrl(String dbUrl){
        this.dbUrl = dbUrl;
    }

    public void DBconnect(){
        System.out.println("DB연결.....["+dbUrl+"]");
    }

    public void call(String message){
        System.out.println("[METHOD] call ===> Message: "+message);
    }

    public void DBdisconnect(){
        System.out.println("DB연결종료.....["+dbUrl+"]");
    }

    @PostConstruct
    public void init() {
        System.out.println("DatabaseClient.init()");
        DBconnect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("DatabaseClient.close()");
        DBdisconnect();
    }

}
