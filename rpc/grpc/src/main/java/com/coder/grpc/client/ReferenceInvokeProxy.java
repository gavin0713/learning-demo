package com.coder.grpc.client;

import com.coder.grpc.annotation.Reference;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class ReferenceInvokeProxy implements BeanPostProcessor{

    @Autowired
    RemoteInvocationHandler invocationHandler;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(Reference.class)){
                field.setAccessible(true);
                //针对这个加了GpReference注解的字段，设置为一个代理的值
                Object proxy = Proxy.newProxyInstance(field.getType().getClassLoader(),new Class<?>[]{field.getType()},invocationHandler);
                try {
                    /**
                     * 相当于 bean.setUser(Proxy)
                     */
                    field.set(bean,proxy); //相当于针对加了GpReference的注解，设置了一个代理，这个代理的实现是inovcationHandler
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
