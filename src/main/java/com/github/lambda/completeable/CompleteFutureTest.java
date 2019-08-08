package com.github.lambda.completeable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;

/**
 * @author : chenxingfei
 * @date: 2019-07-03  22:08
 * @description: java8异步编程
 */
public class CompleteFutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        System.out.println(CompletableFuture.supplyAsync(() -> Thread.currentThread().getName()+" hello").thenApplyAsync(value -> Thread.currentThread().getName()+value + " world").get());

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName() + " hello";
        });

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            return Thread.currentThread().getName() + " world";
        } );

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->{
            return Thread.currentThread().getName() + " world too";
        } );


        String o = stringCompletableFuture.thenCombine(future1, (r1,r2)-> r1+r2).get();
        future2.thenRun(()->{
            System.out.println(Thread.currentThread().getName()+"over");
        });

        System.out.println("\"test\" = " + "test");

        System.out.println(o);
    }
}
