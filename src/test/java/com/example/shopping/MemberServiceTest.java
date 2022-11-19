package com.example.shopping;

import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;
import com.example.shopping.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    void join(){
        //given
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member("geababja111","gae", Grade.GALAXY);

        //when
        memberService.join(member);
        Member findedMember = memberService.findMember("geababja111");

        //then
        Assertions.assertEquals(member.getId(),findedMember.getId());
    }
}
