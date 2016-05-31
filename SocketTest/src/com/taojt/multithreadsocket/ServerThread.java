package com.taojt.multithreadsocket;

import java.io.*;
import java.net.Socket;

/**
 * Created by taojt on 2016/5/31.
 */
public class ServerThread extends Thread{
    Socket socket = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }
    public void run(){
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            is = socket.getInputStream(); //获取输入字节流
            isr = new InputStreamReader(is); // 字节流转换为字符流
            br = new BufferedReader(isr); // 为输入流添加缓冲
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说： " + info);
            }
            //关闭
            socket.shutdownInput();

            // 响应客户端请求
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎您！");
            printWriter.flush();


            socket.shutdownOutput();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (printWriter != null) {
                printWriter.close();
            }
            if (outputStream != null){
                try{
                    outputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (isr != null){
                try {
                    isr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (is != null){
                try{
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
