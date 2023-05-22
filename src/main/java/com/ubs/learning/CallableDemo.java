package com.ubs.learning;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        Callable<String> task = () ->{
            Thread.sleep(200);
             throw new IllegalStateException("Throwing exception by " + Thread.currentThread().getName());
        };

        ExecutorService service = Executors.newFixedThreadPool(2);

        try{
            for(int i=0; i <10 ; i++){
                Future<String> future = service.submit(task);
                System.out.println("Result ::" + future.get(300,TimeUnit.MILLISECONDS));
            }
        }finally {
            service.shutdown();
        }



    }
}
