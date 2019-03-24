package com.github.lambda.stream;

import com.github.lambda.model.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenxingfei
 * 流操作
 */
public class StreamApiTest {


    final ThreadLocal<List<User>> users = ThreadLocal.withInitial(() -> Arrays.asList(

            new User("张三", 1, "张三@github.com"),
            new User("李四", 21, "李四@github.com"),
            new User("王五", 12, "王五@github.com"),
            new User("赵六", 32, "赵六@github.com"),
            new User("赵六", 32, "赵六@github.com"),
            new User("赵六", 32, "赵六@github.com"),
            new User("周五", 33, "周五@github.com"),
            new User("正王", 43, "正王@github.com")

    ));





    /**
     * 筛选和切片
     * filter:按照条件进行过滤，返回一个满足条件的新流
     * limit:查询记录数（从头开始获取）
     * skip:跳过记录数
     * distinct:去重复（需要重新hashCode和equals）
     */
    @Test
    public void testSplit(){
        users.get().stream().filter(o->o.getAge()>1)
                .limit(5)
                .skip(1)
                .distinct()
                .forEach(System.out::println);

    }
}
