package org.tec.utils;

import java.io.Serializable;

public class Test implements Serializable {

    private String name;
    private int age;
    Another another;

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
        this.another = new Another();
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", another=" + another +
                '}';
    }
}
