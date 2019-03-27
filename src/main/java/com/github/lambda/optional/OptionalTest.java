package com.github.lambda.optional;

import com.github.lambda.model.User;
import com.github.lambda.stream.StreamApiTest;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * @author chenxingfei
 * optional测试
 */
public class OptionalTest {

    public static List<User> users = StreamApiTest.users.get();

    /**
     * Optional.of(T t) 创建一个实例
     * * Optional.empty() 创建一个空Optional实例
     * * Optional.ofNullable(T t) 若t为空则返回一个空实例，否则返回Optional实例
     * * Optional.isPresent() 判断是否包含值
     * * Optional.orElse(T t) 如果调用对象包含值，则返回该值，否则返回t
     * * Optional.orElseGet(Supplier s) 如果调用对象包含值，则返回该值，否则返回s获取的值
     * * Optional.map(Function f)  如果有值则对其处理，返回一个Optional实例，否则返回Optional.empty()
     * * Optional.flagMap(Function mapper)  与map类似，要求返回值为Optional实例
     */
    @Test
    public void testOptional() {
        // 创建一个空对象
        System.out.println(Optional.of(new User()).get());
        // NullPointerException
        // System.out.println(Optional.empty().get());
        // NullPointerException
        // System.out.println(Optional.ofNullable(null).get());

        //  若t为空则返回一个空实例，否则返回Optional实例
        Optional<User> o = Optional.ofNullable(null);
        if (o.isPresent()) {
            System.out.println(o.get());
        }
        //  如果调用对象包含值，则返回该值，否则返回t
        User user = o.orElse(new User("123", 12, "1323"));
        System.out.println(user);
        // 如果调用对象包含值，则返回该值，否则返回s获取的值
        User user2 = o.orElseGet(() -> {
            User user1 = new User();
            user1.setAge(12);
            return user1;
        });
        System.out.println(user2);

        // 如果有值则对其处理，返回一个Optional实例，否则返回Optional.empty()
        System.out.println(o.map(User::getAge));
        // 返回值为Optional实例
        Optional<User> user1 = o.flatMap(u -> Optional.of(u));
        Optional<Integer> integer = o.flatMap(u -> Optional.of(u.getAge()));
        System.out.println(integer);


    }
}
