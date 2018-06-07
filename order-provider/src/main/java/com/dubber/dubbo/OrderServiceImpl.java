package com.dubber.dubbo;

import com.dubber.dubbo.order.service.IOrderOperation;
import com.dubber.dubbo.user.IUserBalanceService;
import com.dubber.dubbo.user.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.annotation.Resource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Created on 2018/5/23.
 *
 * @author dubber
 */

@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {

    @Resource
    IOrderOperation orderOperation;
    @Resource
    IUserBalanceService userBalanceService;

    @Autowired
    JtaTransactionManager springTransactionManager;

    @Override
    public OrderResponse doOrder(OrderRequest orderRequest) {
        OrderResponse orderResponse = new OrderResponse();
        String result = "";
        // 下单后更新余额
        UserTransaction userTransaction = springTransactionManager.getUserTransaction();
        try {
            userTransaction.begin();
            orderOperation.inserOrder();
            Response response = userBalanceService.updateUserBalance();
            System.out.println(response.toString());
            userTransaction.commit();
            if (null != response && response.getCode().equals("200")) {
                result = "下单并更新用户余额成功";
            }else{
                result = "下单成功";
            }
            orderResponse.setCode("200");
            orderResponse.setRemark(result);
        } catch (Exception e) {
            try {
                userTransaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            } finally {
                orderResponse.setCode("503");
                orderResponse.setRemark("失败回滚！");
            }
        }
        return orderResponse;
    }
}
