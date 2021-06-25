package com.example.rpcserver;

import com.coder.grpc.annotation.EnableGrpcServer;
import com.coder.grpc.server.InitialMediator;
import com.coder.grpc.server.SocketServerInitial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableGrpcServer
public class RpcServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcServerApplication.class, args);
    }
}
