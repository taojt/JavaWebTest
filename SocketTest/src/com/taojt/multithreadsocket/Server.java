package com.taojt.multithreadsocket;

import java.io.*;
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
            Socket socket = serverSocket.accept(); // accept 阻塞监听
            InputStream is = socket.getInputStream(); //获取输入字节流
            InputStreamReader isr = new InputStreamReader(is); // 字节流转换为字符流
            BufferedReader br = new BufferedReader(isr); // 为输入流添加缓冲
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说： " + info);
            }
            //关闭
            socket.shutdownInput();

            // 响应客户端请求
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎您！");
            printWriter.flush();


            socket.shutdownOutput();
            printWriter.close();
            outputStream.close();

            br.close();
            isr.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
