package com.coder.grpc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class RpcProxyServer {

    private final ExecutorService executorService= Executors.newCachedThreadPool();

    public void publisher(Object service,int port){
        try (ServerSocket serverSocket=new ServerSocket(port)) {
            while(true){
                Socket socket=serverSocket.accept(); //监听客户端请求
                executorService.execute(new ProcessorHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
