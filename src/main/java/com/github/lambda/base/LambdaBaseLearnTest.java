package com.github.lambda.base;

import com.github.lambda.functional.LambdaFunctionalInterace;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda可进行类型推断，所以左侧的参数列表无需增加数据类型
 * 语法格式1：无参数无返回值
 *  ()-> System.out.println("test lambda")
 * 语法格式2：有一个参数无返回值
 *  (str)-> System.out.println(str)
 * 语法格式3：有两个参数并且有返回值
 *  (x, y) -> Integer.compare(x, y)
 * 语法格式4：多个参数，lambda内有多个执行语句，并且还有返回值
 *  (x, y) ->{
 *             System.out.println("比较开始");
 *             int compare = Integer.compare(x, y);
 *             return compare;
 *         }
 * @author chenxingfei
 */
public class LambdaBaseLearnTest {

    /**
     * 测试无参数无返回值lambda写法
     */
    @Test
    public void testNoParamNoReturnValue() {
        new Thread(() -> System.out.println("test lambda")).start();

    }

    /**
     * 测试有一个参数无返回值
     */
    @Test
    public void testHaveOneParamNoReturnValue() {
        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("有一个参数无返回值");

    }

    /**
     * 测试有两个参数并且有返回值
     */
    @Test
    public void testHaveTwoParamHaveReturnValue() {
        Comparator<Integer> comparable = (x, y) -> {
            int compare = Integer.compare(x, y);
            return compare;
        };
    }


    /**
     * 测试多个参数，lambda内有多个执行语句，并且还有返回值
     */
    @Test
    public void  testHaveTwoParamAndManyCodeAndHavReturnValue(){
        Comparator<Integer> comparable = (x, y) ->{
            System.out.println("比较开始");
            int compare = Integer.compare(x, y);
            return compare;
        } ;

    }

    @Test
    public void name() {
    }

    @Test
    public void testFunctionalInterface(){
        System.out.println(getTestValue(11, 22, (x, y) -> x + y));

        Integer bb = 1;
        Integer cc = 1;
        LambdaFunctionalInterace lambdaFunctionalInterace = (xx, yy) -> xx+yy;
        System.out.println(lambdaFunctionalInterace.getResult(bb,cc));
    }


    /**
     * 函数是编程接口
     * @param aa
     * @param bb
     * @param lambdaFunctionalInterace
     * @return
     */
    public Integer getTestValue(Integer aa,Integer bb, LambdaFunctionalInterace lambdaFunctionalInterace){
        return lambdaFunctionalInterace.getResult(aa,bb);

    }
}
