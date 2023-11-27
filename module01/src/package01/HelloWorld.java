// package pkg1[．pkg2[．pkg3…]];
// 方括号内的内容代表其是可选的
package package01;

import java.util.*;
import java.util.regex.*;
import java.time.Instant;

/*
 * newbee01.package01.HelloWorld
 * 一份可能让你重新找回Java语法的程序
 * zll, 2023-11
 */

// -- Java 修饰符
// 访问控制修饰符：public, private, protected, default
// 非访问控制修饰符：final, abstract, static

public class HelloWorld {

    // -- Java 拥有4种变量类型
    // 成员变量（实例变量，instance variable），静态变量（static variable），
    // 局部变量（方法中的变量，local variable），参数变量（参数，Parameters）

    // 这是一个成员变量
    private int instance_variable = 1;
    // 这是一个静态变量
    private static int static_variable = 1;

    // 下面 main 函数的 args 是一个参数变量（Parameter）
    public static void main(String[] args) {
        // 定义在方法中的是局部变量，它不可被访问控制修饰符所修饰。
        int local_variable = 1;

        // -- Java 8种内置数据类型 4种整型 2种浮点型 1种字符型 1种布尔型
        // 整型
        byte byte_v = 1;
        short short_v = 1;
        int int_v = 1;
        long long_v = 1L;
        // 浮点型
        float float_v = 1F;
        double double_v = 1D;
        // 字符型
        char char_v = 'a';
        // 布尔型
        boolean boolean_v = true;

        // -- 包装类：为了满足面向对象的操作，以上8种内置数据类型均拥有其对应的包装类(wrapper class)
        // 自动装箱（boxing）
        Integer wrapped_int = int_v;
        // 自动拆箱（unboxing）
        int unwrapped_int = wrapped_int;

        // -- 数组的声明形式：dataType[] arr_name;，区别于C的不同风格
        // 数组的初始化方法：dataType[] arr_name = new dataType[arrayLength]
        int[] int_arr = new int[10];
        // 数组的另一种初始化方法
        char[] char_arr = {'a', 'b', 'c'};

        // 数组操作，比如填充和排序，可使用来自java.util.Arrays的静态方法
        Arrays.fill(int_arr, 10);
        // 数组适用的 for-each 循环
        for (int item : int_arr) {
            System.out.println(item);
        }

        // -- Java 字符串类 String
        // 通过以下两种方法创建 String 对象的差异
        // 方法一：创建的String位于公共池（Pool）
        String str1 = "hello";
        String str2 = "hello";
//        System.out.println(str1 == str2); // 在公共池中，相同的字符串只存在一份实例，从而减少内存资源的消耗
        // 方法二：创建的String位于堆内存（Heap）中，为所有进程所共享
        String str3 = new String("hello");
        String str4 = new String("hello");
//        System.out.println(str3 == str4); // 对应两份实例

//         String对象一经创建就不可修改，即使通过concat方法实现拼接，也只会生成新的字符串
//         在这点上，String对象可以视作字符串常量
//         要实现可变的字符串，可使用继承自 AbstractStringBuilder 类的 StringBuffer 或 StringBuilde r类
//         它们同时实现了Charsequence和Appendable接口，对字符串的修改操作不会产生新的字符串
//         StringBuilder 操作更轻量，更快，但不具备线程安全性，
//         单线程场景下，优先使用 StringBuilder
//         多线程场景下，由于堆内存中的字符串对象被所有线程共享，需要考虑同步问题，所以优先使用 StringBuffer
//         现代应用程序大多为单线程场景，使用 StringBuilder 较为普遍
        String hello = "hello, ";
//        System.out.println(hello == hello.concat("world"));

        StringBuilder appendable_hello = new StringBuilder("hello, ");
        StringBuilder temp_hello = appendable_hello;
//        System.out.println(temp_hello == appendable_hello.append("world")); // the result is always true;

        // 使用 StringBuilder 和 StringBuffer时需要注意
        StringBuilder sb1 = new StringBuilder("hello");
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println(sb1.equals(sb2));
        // 应当先调用 toString() 方法后，再使用 equals() 方法进行比较
        System.out.println(sb1.toString().equals(sb2.toString()));

//        Java 日期对象 - Date
//        构造一个日期对象（参数留空表示以当前时间初始化）
        Date date = new Date();
//        实例方法 toString() 可用于打印当前日期和时间
//        System.out.println(date.toString());
//        实例方法 getTime() 可用于获取1970年1月1日以来的毫秒数（Milliseconds），以用于时间对象之间的比较
//        System.out.println(date.getTime());

        // Date 类被认为是过时的类，可用 java.time.Instant 包来代替
        Instant currentInstant = Instant.now();
        long seconds = currentInstant.getEpochSecond();
        System.out.println("Current Instant: " + currentInstant);
        // Instant 对象可通过 getEpochSecond() 获取秒数
        System.out.println("Seconds since 1970-01-01: " + seconds);

//     -- Java 正则表达式
    // 场景1：判断一个 String 对象是否与正则表达式匹配
        // 方法1：使用 String.matches()，简洁
        String input1 = "123";
        boolean isMatch1 = input1.matches("\\d+");

        // 使用 Pattern.matches()，需传入两个参数
        // Pattern 的实例方法接收 CharSequence 类型的对象，对 StringBuffer、StringBuilder 都适用
        String input2 = "456";
        boolean isMatch2 = Pattern.matches("\\d+", input2);

        // 如果需要重复使用同一个正则表达式，最好预先编译得到一个 Pattern 对象，以提升代码效率
        Pattern pat = Pattern.compile("\\d+");

    // 场景2：使用正则表达式对一个字符串多次查找匹配，同时提供匹配的具体子序列、起始索引和结束索引等信息
    // 任务：利用正则表达式找出一个句子中的所有单词
        // 预编译，返回可复用的 Pattern 对象
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        // 注意，上述正则表达式没有通过圆括号创建捕获组，这使得以下的 group 方法只会返回匹配的第一个子序列
        Matcher matcher = pattern.matcher("This is a sample sentence with multiple words.");

        // 因此，这里循环使用 Matcher 对象的 find() 方法，返回布尔值表示是否找到匹配的子序列，它的每次调用都会移动到下一个匹配的位置
        while(matcher.find()) {
            // 使用 Matcher 对象的 group(), start(), end() 方法，返回子序列组、起始索引、结束索引
            System.out.println("Matcher.find(): " + matcher.group());
            System.out.println("Start index: " + matcher.start());
            System.out.println("End index: " + matcher.end());
        }

        // 捕获组
        // 创建正则表达式模式，带有一个捕获组，匹配单词边界和一个或多个字母数字字符
        pattern = Pattern.compile("\\b(\\w+)\\b");

        // 创建 Matcher 对象
        matcher = pattern.matcher("This is a sample sentence with multiple words.");

        // 查找匹配的单词
        while (matcher.find()) {
            // 在获取捕获组内的内容之前，一定要先执行 matcher.find()
            System.out.println(matcher.group(0));
            // 当正则表达式中含有捕获组时，matcher.group(0)返回所有捕获组的匹配的内容
            // 这里 matcher.group(1)表示返回第一个捕获组匹配的内容
            String word = matcher.group(1);
            System.out.println("Word: " + word);
        }

        String[] str_arr = {"dog", "cat", "bird"};
        // System.out.println(str_arr[3]); Throws ArrayIndexOutOfBoundsException
        try {
            System.out.println(str_arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caution: Out of Bounds!");
        }

        try {
            sayHello("no");
        } catch (NotHumanNameException e) {
            System.out.println("too short!");
        }

    }

    // Java 方法
    // 方法签名：指方法的 访问控制修饰符 名称 、 参数类型 以及 参数顺序 的组合
    // [访问控制修饰符] [其他修饰符] 返回类型 方法名(参数列表) throws 异常列表 {
    //     方法体
    // }
    // throws 通常是用来给你看的，不一定是让你来写的
    public static String max(int a, int b) {
        if (a > b) {
            return "a is bigger";
        } else if (a < b) {
            return "b is bigger";
        } else {
            return "the same";
        }
    }

    // 使用 throws 关键字声明异常，使得该异常能够被传递
    // 调用这一方法的时候，要么使用try...catch...块捕获异常，要么使用 throws 关键字
    // 使得异常被继续传播下去
    public static void sayHello(String name) throws NotHumanNameException{
        if (name.length() < 3) {
            throw new NotHumanNameException();
        } else {
            System.out.println("Hello, " + name);
        }
    }

    // 重载（Overload）：创建名称相同但参数类型和顺序不同的方法，返回值类型也可以不同
    // 方法被调用时，根据签名自动选择对应的方法（比如此处根据传入的实参类型选择对应方法）
    public static String max(double a, double b) {
        if (a > b) {
            return "a is bigger";
        } else if (a < b) {
            return "b is bigger";
        } else {
            return "the same";
        }
    }

}

