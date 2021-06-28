package com.springbootstudy.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder {

    private final IEncoder iEncoder;

    public Encoder(@Qualifier("base64Encoder") IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
