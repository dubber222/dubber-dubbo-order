package com.dubber.dubbo;

import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/5/26
 */

@Service(value = "orderQuery2")
public class OrderQueryImpl2 implements IOrderQuery {
    @Override
    public String queryOrder() {
        return "query order ******版本2****";
    }
}
