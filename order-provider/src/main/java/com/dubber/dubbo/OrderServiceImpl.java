package com.dubber.dubbo;

/**
 * Created on 2018/5/23.
 *
 * @author dubber
 */
public class OrderServiceImpl implements IOrderService{

    @Override
    public OrderResponse doOrder(OrderRequest orderRequest) {

        System.out.println("来到工厂生产处" + orderRequest);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setData(orderRequest);
        orderResponse.setCode("200");
        orderResponse.setRemark("调用生产成功！！");

        return orderResponse;
    }
}
