package com.example.shopping.LifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient{

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

    //설정정보 초기화 지정 콜백메서드
    public void init() throws Exception {
        System.out.println("NetworkClient.init()");
        connect();
        call("초기화 연결 메시지");
    }

    //설정정보 소멸전 지정 콜백메서드
    public void close() throws Exception {
        System.out.println("NetworkClient.close()");

        disconnect();
    }
}
