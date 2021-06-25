package com.coder.grpc.server;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@Data
public class BeanMethod {
    private Object bean;

    private Method method;
}
