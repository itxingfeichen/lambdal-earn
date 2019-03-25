package com.github.lambda.stream;

import com.github.lambda.model.User;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            new User("赵六", 22, "赵六@github.com"),
            new User("赵六", 100, "赵六@github.com"),
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
    public void testSplit() {
        users.get().stream().filter(o -> o.getAge() > 1)
                .limit(5)
                .skip(1)
                .distinct()
                .forEach(System.out::println);

    }

    /**
     * map 映射
     * map方法将元素转换器为其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flagMap接收一个函数作为参数，将流中每个值都换成另一个流，然后把所有流连成一个流
     */
    @Test
    public void testMap() {

        List<String> collect = users.get().stream().map(User::getUserName).collect(Collectors.toList());
        List<List<Character>> collect1 = collect.stream().map(StreamApiTest::filterCharacter).collect(Collectors.toList());
        System.out.println(collect1);

        // flatMap接收一个函数作为参数，将流中每个值都换成另一个流，然后把所有流连成一个流
        Stream<Character> rStream = collect.stream().flatMap(StreamApiTest::filterCharacterByStream);
        rStream.forEach(System.out::println);
    }

    /**
     * 查找和匹配
     * allMatch(),anyMatch(),noneMatch(),findFirst(),findAny(),count(),max(),min()
     */
    @Test
    public void testSearchAndMatch() {
        // 匹配所有
        boolean b = users.get().stream().allMatch(action -> action.getAge() < 1);
        System.out.println(b);
        // 任意匹配
        boolean b1 = users.get().stream().anyMatch(action -> action.getAge() > 1);
        System.out.println(b1);
        // 校验是否含某个条件的数据，若含有返回false
        boolean b2 = users.get().stream().noneMatch(action -> action.getUserName().equals("张三xx"));
        System.out.println(b2);
        // 查找满足条件的第一个元素
        Optional<User> first = users.get().stream().filter(user -> user.getAge() > 32).findFirst();
        System.out.println(first.get());
        // 查找满足条件的任意一个元素
        Optional<User> result = users.get().parallelStream().filter(user -> user.getUserName().equals("赵六")).findAny();
        System.out.println(result.get());
        // 统计个数
        System.out.println(users.get().stream().count());
        // 查询满足条件的最大值
        Optional<User> max = users.get().stream().max((Comparator.comparing(User::getAge)));
        System.out.println(max.get());
        // 获取最小年龄并返回年龄
        Optional<Integer> min = users.get().stream().map(User::getAge).min(Integer::compareTo);
        System.out.println(min.get());


    }

    @Test
    public void testSorted() {
        List<String> sorts = Arrays.asList("222", "888", "444", "333", "111", "000");
        // 自然排序
        sorts.stream().sorted().forEach(System.out::println);

        // 定制排序
        users.get().stream().sorted((x, y) -> {
            if (x.getAge().compareTo(y.getAge()) == 0) {
                return x.getUserName().compareTo(y.getUserName());
            } else {
                return x.getAge().compareTo(y.getAge());
            }
        }).forEach(System.out::println);

    }

    /**
     * 过滤字符串
     *
     * @param chars
     * @return
     */
    public static List<Character> filterCharacter(String chars) {

        List<Character> character = Lists.newArrayList();
        for (char c : chars.toCharArray()) {
            character.add(c);
        }
        return character;
    }


    /**
     * 过滤字符串
     *
     * @param chars
     * @return
     */
    public static Stream<Character> filterCharacterByStream(String chars) {

        List<Character> character = Lists.newArrayList();


        for (char c : chars.toCharArray()) {
            character.add(c);
        }
        return character.stream();
    }
}
