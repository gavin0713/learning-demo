package com.coder.rpcclient.controller;

import com.coder.grpc.annotation.Reference;
import com.coder.rpcinterface.service.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@RestController
public class TestController {

    @Reference
    private IOrderService orderService; //

    @GetMapping("/test")
    public String test(){
        return orderService.queryOrderList();
    }

    @GetMapping("/get")
    public String get(){
        return orderService.orderById("1");
    }

}
