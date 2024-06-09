package algorithm.solution.smileDK.present.serializable;

import java.io.Serializable;

public class Customer implements Serializable {
    int id;
    String name;
    transient String password;
    int age;

    public Customer(int id, String name, String password, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + '}';
    }
}
