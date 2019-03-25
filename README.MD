## lambda基础知识学习
* lambda是java8中引入的语法，语法格式为 "->"
* "->"称为lambda表达式，表达式左侧表示参数列表，右侧表示表达式中所需要执行的功能。
* lambda表达式需要函数式编程，要求借口只含一个抽象方法，可通过@FunctionalInterface修饰强制要求
* lmabda语法格式说明
     * 语法格式1：无参数无返回值表示方法
       ()-> System.out.println("test lambda")
     * 语法格式2：有一个参数无返回值
       (str)-> System.out.println(str)
     * 语法格式3：有两个参数并且有返回值
       (x, y) -> Integer.compare(x, y)
     * 语法格式4：多个参数，lambda内有多个执行语句，并且还有返回值
       (x, y) ->{
                 System.out.println("比较开始");
                 int compare = Integer.compare(x, y);
                 return compare;
* lambda的四大核心接口
    * Consumer<T> 消费型接口 
        * void accept(T t)
    * Supplier<T> 供给型接口
        * T get()
    Function<T,R> 函数型接口
        * R apply(T t)
    Predicate<T> 断言型接口
        boolean test(T t)  
* java8的方法引用：若lambda中的内容有方法已经实现了，此时可以使用方法引用（方法引用是lambda的另一种表现形式）
    * 语法格式
        * 对象::实例方法名
        * 类名::静态方法名
        * 类::实例方法名
    * 使用条件
        * lambda实现体中调用方法的参数值和返回值类型必须与函数式接口中抽象方法的参数列表和返回值一致
        * 若lambda参数列表中第一个参数是实例方法的调用者，第二个参数是实例方法的参数，才可以使用 类名::方法名
## Stream API
* java8的构造器引用以及数组引用
    * 对象语法格式
        * ClassName::new
    * 数组语法格式
        * ClassName[]::new
* java8的流操作（Stream）
    * 流:是数据渠道，用于操作数据（集合，数组）源所产生的元素序列
        * 注意点
            * 流自己本身不会存储数据
            * Stream不会改变愿数据对象，处理结束后会产生一个新的Stream
            * Stream操作是延迟的，意味着会等到需要的时候再计算
        * 流的操作
            * 创建Stream (串行流和并行流)
                * 创建流通过Collection的stream()方法和parallelStream()
                * 通过Arrays.stream()方法获取数组流
                * 通过Stream的静态of方法创建流
                * 创建无限流，通过Stream.iterate方法创建
                * 通过Stream.generate
            * 中间操作
                * 筛选和切片：filter，limit，skip，distinct
                * map映射：map方法将元素转换器为其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
                          flagMap接收一个函数作为参数，将流中每个值都换成另一个流，然后把所有流连成一个流
                * 排序：自然排序（Comparable），指定排序（Comparator）
                * 查找与匹配：allMatch(),anyMatch(),noneMatch(),findFirst(),findAny(),count(),max(),min()
            * 终端操作（根据用户需要返回结果）
        
