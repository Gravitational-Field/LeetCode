package test.java;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName Person
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/24 11:10
 * @Version 1.0
 **/
public class Person implements Comparable, Cloneable, Serializable {



    @Override
    public int compareTo(Object o) {
        return 0;
    }

    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
