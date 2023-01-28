package com.example.shopping.point;

import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class CrazyPointPolicy implements PointPolicy{
    private int pointGRate = 500;
    private int pointSRate = 200;


    @Override
    public int savePoint(Member member, int price) {
        if(member.getGrade()== Grade.GALAXY) {
            return pointGRate*1000;
        }
        else
            return pointSRate*1000;
    }
}
