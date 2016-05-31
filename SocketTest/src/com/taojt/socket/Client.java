package com.taojt.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by taojt on 2016/5/31.
 */
public class Client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 8888);
            OutputStream outputStream = socket.getOutputStream(); // 获取字节输出流
            PrintWriter printWriter = new PrintWriter(outputStream); //字节流转换为打印流
            printWriter.write("用户名: admin; pass: 12345");
            printWriter.flush(); // 刷新缓存
            socket.shutdownOutput();

            //获取输入流
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("我是客户端，服务端响应： " + info);
            }
            socket.shutdownInput();
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            printWriter.close();
            outputStream.close();
            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
