package com.example.shopping.AllBeans;

import com.example.shopping.AppConfig;
import com.example.shopping.AutoAppConfig;
import com.example.shopping.member.Grade;
import com.example.shopping.member.Member;
import com.example.shopping.point.PointPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeansTest {


    @Test
    @DisplayName("List으로 모든 빈 조회")
    void AllBeanByList(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class, PointService.class);
        PointService pointService = ac.getBean(PointService.class);

        Member member = new Member("userid1","member1", Grade.GALAXY);

        int discountPoint = pointService.discountPoint(member,10000,"crazyPointPolicy");

        Assertions.assertThat(pointService).isInstanceOf(PointService.class);
        Assertions.assertThat(discountPoint).isEqualTo(500000);
        System.out.println("포인트 : "+discountPoint);
    }

    static class PointService{
        private final Map<String, PointPolicy> policyMap;
        private final List<PointPolicy> policyList;

        public PointService(Map<String, PointPolicy> policyMap, List<PointPolicy> policyList){
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("======> 전체 빈 조회");
            System.out.println("policyMap : "+policyMap);
            System.out.println("policyList : "+policyList);
        }

        public int discountPoint(Member member, int price, String pointCode){

            PointPolicy pointPolicy = policyMap.get(pointCode);

            System.out.println("pointCode: "+ pointCode);
            System.out.println("pointPolicy : "+pointPolicy);

            return pointPolicy.savePoint(member,price);
        }
    }
}
