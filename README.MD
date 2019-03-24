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
