package com.example.shopping.Scope;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class SingletonWithPrototype {

    @Test
    @DisplayName("프로토타입 빈 테스트")
    void prototypeBeanTest(){
        //new AnnotationConfigApplicationContext(SingletonBean.class)하면 자동으로 CompoenetScan이 된다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2= ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        prototypeBean2.addCount();
        System.out.println("prototypeBean1 : "+prototypeBean1.getCount());
        System.out.println("prototypeBean2 : "+prototypeBean2.getCount());

        Assertions.assertThat(prototypeBean1.getCount()).isSameAs(prototypeBean2.getCount());


        //수동종료
        prototypeBean1.destroy();
        prototypeBean2.destroy();

        //스프링 컨테이너 종료
        ac.close();
    }

    @Test
    @DisplayName("")
    void SingletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        System.out.println("count1 : "+count1);
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        System.out.println("count2 : "+count2);
        Assertions.assertThat(count2).isEqualTo(1);

        ac.close();
    }

    @Scope("singleton")
    static class ClientBean{
        @Autowired
        private Provider<PrototypeBean> provider; //생성시점에 같이 주입됨.

        public int logic(){
            PrototypeBean prototypeBean = provider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean{

        public int count=0;
        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }
        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init ==> "+this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }
}
