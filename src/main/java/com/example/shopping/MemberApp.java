package com.example.shopping;

import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;
import com.example.shopping.member.MemberService;
import com.example.shopping.member.MemberServiveImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //스프링컨테이너 불러오기
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        Member member = new Member("gaebabja111","gae", Grade.GALAXY);

        memberService.join(member);

        Member findedMember = memberService.findMember("gaebabja111");
        System.out.println("findedMember => "+findedMember.getId());
        System.out.println("member => "+member.getId());
    }

}
