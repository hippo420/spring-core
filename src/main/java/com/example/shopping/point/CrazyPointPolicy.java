package com.example.shopping.point;

import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;

public class CrazyPointPolicy implements PointPolicy{
    private int pointGRate = 50;
    private int pointSRate = 20;


    @Override
    public int savePoint(Member member, int price) {
        if(member.getGrade()== Grade.GALAXY)
            return (int)(price * (double)(pointGRate/100));
        else
            return (int)(price * (double)(pointSRate/100));
    }
}
