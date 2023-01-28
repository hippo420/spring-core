package com.example.shopping.web;

import com.example.shopping.Logger.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final Logger logger;
    //private final ObjectProvider<Logger> loggerObjectProvider;

    public void log(String id){
        //Logger logger = loggerObjectProvider.getObject();
        logger.log("service_id : "+id);
    }
}
