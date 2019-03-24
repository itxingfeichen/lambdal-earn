package com.github.lambda.reference;


import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * 对象引用测试
 * @author chenxingfei
 */
public class ObjectReferenceTest {


    /**
     * 测试对象引用
     */
    @Test
    public void testObjectReference(){

        Consumer<String> consumer = System.out::println;

        consumer.accept("object reference");
    }


    /**
     * 测试类引用静态方法
     */
    @Test
    public void testClassReference(){

        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);

        Comparator<Integer> comparator1 =  Integer::compare;
    }


    /**
     * 测试类引用实例方法
     */
    @Test
    public void testClassReferenceInstanceMethod(){

        BiPredicate<String,String> biPredicate = (x,y)->x.equals(y);
        System.out.println(biPredicate.test("1", "2"));

        BiPredicate<String,String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("1", "1"));
    }
}
