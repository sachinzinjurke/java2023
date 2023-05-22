package com.ubs.learning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloWorld {

    public static void main(String[] args) {

        Runnable task = ()-> System.out.println("I am executing in thread:" + Thread.currentThread().getName());

        ExecutorService service = Executors.newFixedThreadPool(2);

        for(int i=0; i <10 ; i++){
           service.execute(task);
        }

        service.shutdown();

    }
}
