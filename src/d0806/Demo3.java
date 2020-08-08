package d0806;

import java.util.Objects;

public class Demo3 {
    public static void main(String[] args) {
        Object a = new Object();
        //任何继承Object 的子类，如果没有重写equals方法
        //那么equals就等效于 ==
        //String 的equals是被重写的
        a.equals(1);

        Object b = new Integer(100);
        Object c = "123";//String
        Object d = 100;//100==>Integer装箱==>Object

        //getClass 获取类对象
        System.out.println("======获取对象实际类型getClass======");
        System.out.println(a.getClass());
        System.out.println(b.getClass());
        System.out.println(c.getClass());
        System.out.println(d.getClass());

        System.out.println("=======toString 输出对象的字符串形式的值=======");
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());

        Person p = new Person("武松", 35);
        System.out.println(p.toString());
        System.out.println(p);

        System.out.println("======自定义对象的对比======");
        Person p1 = new Person("武松", 35);
        System.out.println(p == p1);
        System.out.println(p.equals(p1));

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

