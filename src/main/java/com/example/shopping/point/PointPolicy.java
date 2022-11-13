package com.example.shopping.point;

import com.example.shopping.member.Member;

public interface PointPolicy {

    int savePoint(Member member,int price);

}
