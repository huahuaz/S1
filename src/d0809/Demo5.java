package d0809;

import java.io.*;

public class Demo5 {
    public static void main(String[] args) {
        //save();
        load();
    }

    public static void load() {
        FileInputStream fis = null;
        ObjectInputStream dis = null;
        try {
            fis = new FileInputStream("d:/temp/a.dat");
            dis = new ObjectInputStream(fis);
            Person p = (Person) dis.readObject();
            System.out.println(p.name);
            System.out.println(p.age);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            Demo4.close(fis);
            Demo4.close(dis);
        }
    }

    public static void save() {
        Person p = new Person("吴邪", 36);
        //资源流
        FileOutputStream fos = null;
        //处理流
        //DataOutputStream  只能写基本数据类型的数据
        //DataOutputStream dos = null;
        ObjectOutputStream dos = null;
        try {
            fos = new FileOutputStream("d:/temp/a.dat");
            dos = new ObjectOutputStream(fos);
            dos.writeObject(p);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Demo4.close(fos);
            Demo4.close(dos);
        }
    }
}

//NotSerializableException: d0809.Person
//Person未实现序列化接口
//序列化，就是将数据转换成字节流
class Person implements java.io.Serializable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
