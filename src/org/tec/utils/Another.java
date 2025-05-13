package org.tec.utils;

import java.io.Serializable;

public class Another implements Serializable {

    private String name;

    public Another() {
        this.name = "Default Name";
    }

    @Override
    public String toString() {
        return "Another{" +
                "name='" + name + '\'' +
                '}';
    }
}
