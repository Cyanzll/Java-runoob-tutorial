/*
 *  涉及内容：
 *  继承
 *  接口
 *  封装
 *  多态
 *  泛型列表
 */

package package01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OopZoo {
    public static void main(String[] args) {
        // 向上转型，实现多态
        SoundMaker dog_1 = new Dog("Tom", 3, "Admin");
        SoundMaker dog_2 = new Dog("Ben", 7, "Admin");
        SoundMaker bird_1 = new Bird("Amy", 7);
        SoundMaker bird_2 = new Bird("Candy", 5);


        // 声明泛型数组
        ArrayList<SoundMaker> animals = new ArrayList<>();
        animals.add(dog_1);
        animals.add(dog_2);
        animals.add(bird_1);
        animals.add(bird_2);

        for (SoundMaker e : animals) {
            e.makeSound();
        }

    }

    // 泛型方法定义，要注意：泛型参数应位于返回值类型之前
    public static <T> void iterPrintlnString (T object) {
        System.out.println(object.toString());
    }
}

interface SoundMaker {
    void makeSound();
}

interface Fly {
    void flyToSomeWhere(String destination);
}

class Dog extends Animal implements SoundMaker {

    private String owner;
    public Dog(String name, int age, String owner) {
        super(name, age);
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Bird extends Animal implements Fly, SoundMaker {
    public Bird(String name, int age) {
        super(name, age);
    }
    @Override
    public void flyToSomeWhere(String destination) {
        System.out.println("Flying to " + destination + ".");
    }

    @Override
    public void makeSound() {
        System.out.println("Gugu!");
    }
}

class Animal {
    // 属性
    private String name;
    private int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 封装 - 访问器
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
