package com.dubber.dubbo;

/**
 * Created on 2018/5/23.
 *
 * @author dubber
 */
public interface IOrderService {

    /**
     * 下单操作
     *
     * @param orderRequest 下单请求
     * @return
     */
    OrderResponse doOrder(OrderRequest orderRequest);
}
