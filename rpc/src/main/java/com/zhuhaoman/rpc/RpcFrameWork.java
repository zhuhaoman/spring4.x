package com.zhuhaoman.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName RpcFrameWork
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/9/27 15:33
 **/
public class RpcFrameWork {


    public static void export(final Object service, int port) throws Exception {
        if (service == null)
            throw new IllegalArgumentException("service instance == null");

        if (port <= 0 || port > 65535)
            throw new IllegalArgumentException("Invalid port " + port);

        System.out.println("Export service " + service.getClass().getName() + " on port " + port);

        ServerSocket server = new ServerSocket(port);
        while (true) {
            final Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        String methodName = input.readUTF();
                        Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                        Object[] arguments = (Object[]) input.readObject();

                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                        service.getClass().getMethod();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            })
        }
    }
}
