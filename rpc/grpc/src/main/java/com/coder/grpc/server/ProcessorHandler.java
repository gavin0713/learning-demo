package com.coder.grpc.server;

import com.coder.grpc.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class ProcessorHandler implements Runnable{

    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream())) {
            RpcRequest request=(RpcRequest)inputStream.readObject(); //反序列化
            //路由
            Mediator mediator=Mediator.getInstance();
            Object rs=mediator.processor(request);
            System.out.println("服务端的执行结果："+rs);
            outputStream.writeObject(rs);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
