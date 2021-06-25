package com.coder.grpc.annotation;

import com.coder.grpc.server.InitialMediator;
import com.coder.grpc.server.SocketServerInitial;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SocketServerInitial.class, InitialMediator.class})
public @interface EnableGrpcServer { }
