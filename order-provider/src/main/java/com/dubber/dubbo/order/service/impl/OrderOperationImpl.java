package com.dubber.dubbo.order.service.impl;

import com.dubber.dubbo.order.service.IOrderOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/6/5
 */

@Repository(value = "orderOperation")
public class OrderOperationImpl implements IOrderOperation {

    @Autowired
    JdbcTemplate orderJdbcTemplate;

    @Override
    public void inserOrder() {
        orderJdbcTemplate.execute("INSERT INTO `order`(`price`,`createTime`) VALUES(20,NOW())");
    }
}
