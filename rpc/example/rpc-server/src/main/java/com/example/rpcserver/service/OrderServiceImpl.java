package com.example.rpcserver.service;

import com.coder.grpc.annotation.RemoteService;
import com.coder.rpcinterface.service.IOrderService;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RemoteService
public class OrderServiceImpl implements IOrderService {

    @Override
    public String queryOrderList() {
        return "query method";
    }

    @Override
    public String orderById(String id) {
        return "order method";
    }
}
