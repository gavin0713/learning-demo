package com.coder.rpcclient;

import com.coder.grpc.annotation.EnableGrpcClient;
import com.coder.grpc.client.ReferenceInvokeProxy;
import com.coder.grpc.client.RemoteInvocationHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableGrpcClient
public class RpcClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcClientApplication.class, args);
    }
}
