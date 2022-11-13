package com.example.shopping;

import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;
import com.example.shopping.member.MemberService;
import com.example.shopping.member.MemberServiveImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiveImpl();
    @Test
    void join(){
        //given
        Member member = new Member("geababja111","gae", Grade.GALAXY);

        //when
        memberService.join(member);
        Member findedMember = memberService.findMember("geababja111");

        //then
        Assertions.assertEquals(member.getId(),findedMember.getId());
    }
}
