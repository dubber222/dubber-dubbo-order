package com.dubber.dubbo;

import java.io.Serializable;

/**
 * Created on 2018/5/23.
 *
 * @author dubber
 */
public class OrderResponse implements Serializable{
    private static final long serialVersionUID = -3277473130189278753L;

    private Object data;
    private String code;
    private String remark;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "data=" + data +
                ", code='" + code + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
