package com.coder.rpcclient;

import com.coder.grpc.annotation.EnableGrpcClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGrpcClient
public class RpcClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcClientApplication.class, args);
    }
}
