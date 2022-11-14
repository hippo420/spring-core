package com.example.shopping.point;

import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;

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
