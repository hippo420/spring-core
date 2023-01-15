package com.example.shopping.point;
import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("NonCrazyPointPolicy")
public class NonCrazyPointPolicy implements PointPolicy {

    private int Point = 500;

    @Override
    public int savePoint(Member member, int price) {
        if(member.getGrade()== Grade.GALAXY)
            return Point;
        else
            return 100;


    }
}
