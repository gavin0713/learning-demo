package com.coder.grpc.client;

import com.coder.grpc.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class RpcNetTransport {

    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Socket newSocket() throws IOException {
        return new Socket(host, port);
    }

    public Object send(RpcRequest request){
        try {
            Socket socket = newSocket();
            //IO操作
            try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
                outputStream.writeObject(request);
                outputStream.flush();
                return inputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
