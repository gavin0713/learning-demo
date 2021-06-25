package com.coder.grpc.annotation;


import com.coder.grpc.client.ReferenceInvokeProxy;
import com.coder.grpc.client.RemoteInvocationHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({RemoteInvocationHandler.class, ReferenceInvokeProxy.class})
public @interface EnableGrpcClient { }
