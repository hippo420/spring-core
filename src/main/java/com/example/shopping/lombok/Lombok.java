package com.example.shopping.lombok;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Lombok {

    private String id;
    private String passwd;


    public static void main(String[] args){
        Lombok lombok = new Lombok();
        lombok.setId("lombok...");
        lombok.setPasswd("1234");
        System.out.println(lombok.getClass()+"=>"+lombok.getId()+ ", "+ lombok.getPasswd());
        System.out.println(lombok);
    }
}
