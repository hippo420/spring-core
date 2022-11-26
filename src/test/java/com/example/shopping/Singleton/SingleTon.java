package com.example.shopping.Singleton;

public class SingleTon {

    //static에 객체 하나만 생성
    private static final SingleTon instance = new SingleTon();

    //객체 인스턴스 생성
    public static SingleTon getInstance(){
        return instance;
    }

    //private로 외부에서 new로 객체생성 못하게 막음!!!
    private SingleTon(){};
}
