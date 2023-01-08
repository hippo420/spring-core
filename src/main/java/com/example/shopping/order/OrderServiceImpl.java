package com.example.shopping.order;

import com.example.shopping.member.Member;
import com.example.shopping.member.MemberRepository;
import com.example.shopping.member.MemoryMemberRepository;
import com.example.shopping.point.NonCrazyPointPolicy;
import com.example.shopping.point.PointPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final PointPolicy pointPolicy = new NonCrazyPointPolicy();

    //INFO
    //DI
    private final MemberRepository memberRepository;
    private final PointPolicy pointPolicy;



    //ComponentScan을 사용하기 때문에 의존성을 자동주입함
        @Autowired
        public OrderServiceImpl(MemberRepository memberRepository, PointPolicy pointPolicy) {
            System.out.println("OrderServiceImpl");
            this.memberRepository = memberRepository;
            this.pointPolicy = pointPolicy;
        }

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
