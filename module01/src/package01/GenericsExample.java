package package01;

import java.util.ArrayList;

public class GenericsExample {
    public static void main(String[] args) {
        // 不使用泛型，下列代码实际上创建了一个可以存放任意元素的数组
        // 由于Java引用类型变量实际存储的是地址，因此编译器无法进行类型检查
        ArrayList list = new ArrayList();
        list.add("Tom");
        list.add(3);
        list.add(true);

        // 如果期望建立一个元素类型固定的数组，可通过泛型实现编译时的类型检查
        // 需要注意：泛型参数均会在编译后被擦除，泛型永远是在提醒编译器应当怎么编译你的程序
        // 运行时是不存在泛型的
        ArrayList<String> listGenerics = new ArrayList<>();
        listGenerics.add("good");
        // listGenerics.add(3); 报错

    }
}
