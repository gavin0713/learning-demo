package com.example.rpcserver;

import com.coder.grpc.annotation.EnableGrpcServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGrpcServer
public class RpcServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcServerApplication.class, args);
    }
}
