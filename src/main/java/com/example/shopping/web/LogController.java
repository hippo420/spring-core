package com.example.shopping.web;

import com.example.shopping.Logger.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;
    private final Logger logger;
    //private final ObjectProvider<Logger> loggerObjectProvider;

    @RequestMapping("log")
    @ResponseBody
    public String log(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
        //Logger logger =loggerObjectProvider.getObject();
        logger.setRequestURL(requestURL);
        System.out.println("Looger: "+logger.getClass());
        logger.log("controller call");
        logService.log("gaebabja");
        return "OK";
    }
}
//오류나는 이유 : 스프링이 뜰 떄 빈을 등록하는데 scope = request라서 request가 있어야 됨
//             근데 request가 없다보니 오류
//스프링 애플리케이션을 실행 시키면 오류가 발생한다. 메시지 마지막에 싱글톤이라는 단어가 나오고..
//스프링 애플리케이션을 실행하는 시점에 싱글톤 빈은 생성해서 주입이 가능하지만,
//request 스코프 빈은 아직 생성되지 않는다. 이 빈은 실제 고객의 요청이 와야 생성할 수 있다!
// => Provier로 해결