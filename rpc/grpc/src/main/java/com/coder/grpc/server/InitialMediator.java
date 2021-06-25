package com.coder.grpc.server;

import com.coder.grpc.annotation.RemoteService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

public class InitialMediator implements BeanPostProcessor{

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //
        if(bean.getClass().isAnnotationPresent(RemoteService.class)){ //加了服务发布标记的bean进行远程发布
            System.out.println(beanName);
            Method[] methods=bean.getClass().getDeclaredMethods();
            for(Method method:methods){
                String key=bean.getClass().getInterfaces()[0].getName()+"."+method.getName();
                BeanMethod beanMethod=new BeanMethod();
                beanMethod.setBean(bean);
                beanMethod.setMethod(method);
                Mediator.map.put(key,beanMethod);
            }
        }
        return bean;
    }
}
