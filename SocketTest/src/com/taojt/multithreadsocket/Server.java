package com.taojt.multithreadsocket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by taojt on 2016/5/31.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("*****服务器开始启动，等待调用****");
            Socket socket = null;
            int count = 0;
            while (true){
                socket = serverSocket.accept(); // 循环监听
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("当前客户端的数量： " + count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("当前客户端的IP： " + inetAddress.getHostAddress());
            }
//            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
