package com.github.lambda.reference;


import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * 构造器引用
 * @author chenxingfei
 *
 */
public class ConstructorReferenceTest {

    /**
     * 测试无参数构造引用
     */
    @Test
    public void testNoParamConstructor(){
        Supplier<String> stringSupplier = ()->new String();
        String s = stringSupplier.get();
        System.out.println(s);
        Supplier<String> supplier =  String::new;
        String s1 = supplier.get();
    }

    /**
     * 测试带参数构造器
     * 注意：需要调用的构造器中，参数需要与函数式接口中的参数保持一致
     */
    @Test
    public void testHaveOneConstructor(){

        Function<String,String> function  = (aa)->new String(aa);
        String aa = function.apply("aa");

        System.out.println(aa);

        Function<String,String> function1 = String::new;
        String aa1 = function1.apply("bb");
        System.out.println(aa1);
    }

    /**
     * 测试数组引用
     */
    @Test
    public void testArrayReference(){

        // lambda写法
        Function<Integer,String[]> function = (x)->new String[x];
        System.out.println(function.apply(3).length);

        // 数组引用写法
        Function<Integer,String[]> integerFunction = String[]::new;

        System.out.println(integerFunction.apply(4).length);

    }
}
