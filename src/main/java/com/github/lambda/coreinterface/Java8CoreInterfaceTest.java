package com.github.lambda.coreinterface;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lambda的四大核心接口
 *     * Consumer<T> 消费型接口
 *         * void accept(T t)
 *     * Supplier<T> 供给型接口
 *         * T get()
 *     Function<T,R> 函数型接口
 *         * R apply(T t)
 *     Predicate<T> 断言型接口
 *         boolean test(T t)
 * @author chenxingfei
 */
public class Java8CoreInterfaceTest {


    /**
     * 消费型接口测试
     */
    @Test
    public void testConsumer(){
        Consumer consumer = (aa)-> System.out.println("消费型接口没有返回值"+"消费参数="+aa);
        consumer.accept("java 8 消费型接口学习");
    }

    /**
     * 供给型接口测试
     */
    @Test
    public void testSupplier(){
        Supplier<Integer> supplier = ()-> BigDecimal.valueOf(1L).compareTo(BigDecimal.valueOf(1L));
        System.out.println(supplier.get());
    }

    /**
     * 函数型接口测试
     */
    @Test
    public void testFunction(){
        Function<Integer,String> function = (aa)->aa.toString();
        Function<Integer, String> function1 = function.andThen((aa) -> aa + "0000000");
        System.out.println(function.apply(21));
        System.out.println(function1.apply(32));
    }


    /**
     * 断言型接口测试
     */
    @Test
    public void testPredicate(){
        Predicate<Integer> predicate = (aa)->aa>0;
        Predicate<Integer> and = predicate.and((aa) -> aa > 1);
        System.out.println(and.test(0));
        System.out.println(and.test(1));
        System.out.println(and.test(2));
    }
}
