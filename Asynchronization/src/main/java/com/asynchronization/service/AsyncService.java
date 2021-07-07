package com.asynchronization.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
public class AsyncService {

    @Async("async-thread")
    public CompletableFuture run(){
        return new AsyncResult<>(hello()).completable();
    }

    public String hello() {

        for(int i = 0; i<10; i++){
            try{
                Thread.sleep(2000);
                log.info("thread sleep....");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return "async hello";
    }
}
