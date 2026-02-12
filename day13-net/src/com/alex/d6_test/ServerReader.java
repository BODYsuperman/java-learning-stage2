package com.alex.d6_test;

import java.io.*;
import java.net.Socket;

public class ServerReader extends Thread{

    private Socket socket;
    public  ServerReader(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintStream ps = new PrintStream(outputStream);
            // 1. 第一步：输出 HTTP 响应头（必须符合 HTTP 协议规范）
            // HTTP/1.1 200 OK 表示响应成功
            // Content-Type: text/html; charset=utf-8 告诉浏览器返回的是 HTML 内容，编码为 UTF-8
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type: text/html; charset=utf-8");
            ps.println(); // 响应头和响应体之间必须有一个空行（HTTP 协议要求）

            // 2. 第二步：输出网页的 HTML 内容（响应体）
            String htmlPage = """
                    <!DOCTYPE html>
                    <html lang="zh-CN">
                    <head>
                        <meta charset="UTF-8">
                        <title>极简 TCP 网页服务器</title>
                        <style>
                            body { font-family: Arial, sans-serif; margin: 50px; text-align: center; }
                            h1 { color: #2c3e50; }
                            .content { background: #f5f5f5; padding: 20px; border-radius: 8px; }
                        </style>
                    </head>
                    <body>
                        <div class="content">
                            <h1>你好！这是来自 TCP 服务器的网页</h1>
                            <p>客户端 IP：%s</p>
                            <p>客户端端口：%d</p>
                            <p>这是一个完整的 HTML 网页，由 Java TCP Socket 直接返回</p>
                        </div>
                    </body>
                    </html>
                    """.formatted(
                    socket.getInetAddress().getHostAddress(), // 客户端 IP
                    socket.getPort() // 客户端端口
            );
            ps.println(htmlPage);

            // 刷新流，确保数据全部发送
            ps.flush();
            // 关闭资源
            ps.close();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Client is dead!");
        }
    }
}
