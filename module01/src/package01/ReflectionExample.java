package package01;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.*;

public class ReflectionExample {
    public static void main(String[] args) {

        // 以下例子，如果不通过反射将难以实现
        System.out.println("输入你打算实例化的类名");
        Scanner scan = new Scanner(System.in);
        try {
            // 根据 forName 方法 获取类的 Class 对象
            // 可输入例如：java.util.Date
            Class<?> newClass = Class.forName(scan.next());
            // 利用 Class 对象创建类的实例
            Object obj = newClass.getDeclaredConstructor().newInstance();
            System.out.println("成功创建了一个 " + newClass.getName() + " 的实例。");
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            System.out.println("实例化失败。");
            e.printStackTrace();
        }
    }
}
