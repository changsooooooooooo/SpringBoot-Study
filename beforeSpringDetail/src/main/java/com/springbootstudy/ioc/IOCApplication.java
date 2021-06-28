package com.springbootstudy.ioc;

import com.springbootstudy.SpringBootStudyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
class IOCApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootStudyApplication.class, args);
        ApplicationContext applicationContext = ApplicationContextProvider.getContext();
//        Base64Encoder base64Encoder = applicationContext.getBean(Base64Encoder.class);
        Encoder encoder = applicationContext.getBean("urlEncode", Encoder.class);
        System.out.println(encoder.encode("www.naver.com"));
    }
}

@Configuration
class AppConfig{

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }
}
