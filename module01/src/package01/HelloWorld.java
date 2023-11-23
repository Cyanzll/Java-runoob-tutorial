package package01;

import java.util.*;

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
        System.out.println(str1 == str2); // 在公共池中，相同的字符串只存在一份实例，从而减少内存资源的消耗
        // 方法二：创建的String位于堆内存（Heap）中，为所有进程所共享
        String str3 = new String("hello");
        String str4 = new String("hello");
        System.out.println(str3 == str4); // 对应两份实例

//         String对象一经创建就不可修改，即使通过concat方法实现拼接，也只会生成新的字符串
//         在这点上，String对象可以视作字符串常量
//         要实现可变的字符串，可使用继承自 AbstractStringBuilder 类的 StringBuffer 或 StringBuilde r类
//         它们同时实现了Charsequence和Appendable接口，对字符串的修改操作不会产生新的字符串
//         StringBuilder 操作更轻量，更快，但不具备线程安全性，
//         单线程场景下，优先使用 StringBuilder
//         多线程场景下，由于堆内存中的字符串对象被所有线程共享，需要考虑同步问题，所以优先使用 StringBuffer
//         现代应用程序大多为单线程场景，使用 StringBuilder 较为普遍
        String hello = "hello, ";
        System.out.println(hello == hello.concat("world"));

        StringBuilder appendable_hello = new StringBuilder("hello, ");
        StringBuilder temp_hello = appendable_hello;
        System.out.println(temp_hello == appendable_hello.append("world")); // the result is always true;

//        Java 日期对象 - Date
//        构造一个日期对象（参数留空表示以当前时间初始化）
        Date date = new Date();
//        实例方法 toString() 可用于打印当前日期和时间
        System.out.println(date.toString());
//        实例方法 getTime() 可用于获取1970年1月1日以来的毫秒数（Milliseconds），以用于时间对象之间的比较
        System.out.println(date.getTime());

    }
}
