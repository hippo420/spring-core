package com.example.shopping.Singleton;



public class SingletonStateful {

    //상태 유지 필드
    private int age;

    public void editAge(String name, int age){
        System.out.println("이름: "+name+" 나이: "+age);
        //필드 설정
        this.age=age;
    }

    public int getAge(){
        return age;
    }

    //unStateful로 구현
    public int editAgeByUnstateful(String name, int age){
        System.out.println("이름: "+name+" 나이: "+age);
        return age;
    }
}
