package com.example.shopping.order;

import com.example.shopping.member.Member;
import com.example.shopping.member.MemberRepository;
import com.example.shopping.member.MemoryMemberRepository;
import com.example.shopping.point.NonCrazyPointPolicy;
import com.example.shopping.point.PointPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final PointPolicy pointPolicy = new NonCrazyPointPolicy();

    //INFO
    //DI
    private final MemberRepository memberRepository;
    private final PointPolicy pointPolicy;


    @Override
    public Order createOrder(String memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int savePoint = pointPolicy.savePoint(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, savePoint);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
