package com.coder.grpc.server;

import com.coder.grpc.annotation.RemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@Slf4j
public class InitialMediator implements BeanPostProcessor{

    /**
     *
     * 借助spring的扫描机制，扫描需要注册为rpc的服务，对加了服务发布标记的bean进行远程发布
     *
     * @param bean 被spring 扫描的 bean 实例
     * @param beanName bean 名称
     * @return 返回 bean 实例
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(RemoteService.class)){
            log.info("add {} to remote service", beanName);
            Method[] methods = bean.getClass().getDeclaredMethods();

            for(Method method : methods){
                String key = bean.getClass().getInterfaces()[0].getName() + "." + method.getName();
                BeanMethod beanMethod = new BeanMethod();
                beanMethod.setBean(bean);
                beanMethod.setMethod(method);
                Mediator.map.put(key,beanMethod);
            }
        }
        return bean;
    }
}
