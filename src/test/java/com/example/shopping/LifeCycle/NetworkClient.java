package com.example.shopping.LifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean,DisposableBean{

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출 Url : "+url);
       // connect();
       // call("초기화 메세지 출력......");
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("연결.....["+url+"]");
    }

    public void call(String message){
        System.out.println("[METHOD] call ===> Message: "+message);

    }

    public void disconnect(){
        System.out.println("연결종료.....["+url+"]");
    }

    //의존관계 주입이 끝나면(InitializingBean) 초기화 콜백메서드
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet()");
        connect();
        call("초기화 연결 메시지");
    }

    //(DisposableBean) 소멸전 콜백메서드
    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
