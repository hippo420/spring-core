package com.example.shopping.BeanCallbackProperty;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

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

    //설정정보 => 소멸 지정 콜백메서드
    public void close() throws Exception {
        System.out.println("DatabaseClient.close()");
        DBdisconnect();
    }

    //설정정보 => 초기화 지정 콜백메서드
    public void init() throws Exception {
        System.out.println("DatabaseClient.init()");
        DBconnect();
        call("초기화 연결 메시지");
    }
}
