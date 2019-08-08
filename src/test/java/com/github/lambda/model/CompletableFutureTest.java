package com.github.lambda.model;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 *
 * @author : chenxingfei
 * @date: 2019-08-08  21:51
 * @description: {@link CompletableFuture} test
 */
public class CompletableFutureTest {

    /**
     * get current thread name form current thread
     * @return
     */
    public String getCurrentName(){
        return Thread.currentThread().getName();
    }

    @Test
    public void test1() throws ExecutionException, InterruptedException {

        // non return value
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getCurrentName() + "non return value");
        });
        TimeUnit.SECONDS.sleep(3);
        System.out.println("async ?");
        // get method will be throw ExecutionException @see join()
        // voidCompletableFuture.get();
        voidCompletableFuture.join();
    }

    /**
     * executing by async and with executor pool
     */
    @Test
    public void test2(){
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> System.out.println(getCurrentName() + " executing by async and with executor pool"), Executors.newFixedThreadPool(3));

        voidCompletableFuture.join();

    }

    /**
     * the category of supply
     */
    @Test
    public void test3(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> getCurrentName()+" result");

        System.out.println(getCurrentName()+" supply async test");
        String join = future.join();

        System.out.println(getCurrentName()+"  "+join);

    }




}
