package com.example.shopping.BeanCallbackInterface;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class DatabaseClient implements InitializingBean, DisposableBean {

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

    //(DisposableBean) 소멸전 콜백메서드
    @Override
    public void destroy() throws Exception {
        System.out.println("DatabaseClient.close()");
        DBdisconnect();
    }

    //의존관계 주입이 끝나면(InitializingBean) 초기화 콜백메서드
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DatabaseClient.init()");
        DBconnect();
        call("초기화 연결 메시지");
    }
}
