package com.dubber.dubbo;

import java.io.Serializable;

/**
 * Created on 2018/5/23.
 *
 * @author dubber
 */
public class OrderRequest implements Serializable{

    private static final long serialVersionUID = -7295405008532426305L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
