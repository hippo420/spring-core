package com.example.shopping;

import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;
import com.example.shopping.member.MemberService;
import com.example.shopping.member.MemberServiveImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiveImpl();
        Member member = new Member("gaebabja111","gae", Grade.GALAXY);

        memberService.join(member);

        Member findedMember = memberService.findMember("gaebabja111");
        System.out.println("findedMember => "+findedMember.getId());
        System.out.println("member => "+member.getId());
    }

}
