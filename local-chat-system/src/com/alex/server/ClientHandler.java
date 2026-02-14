package com.alex.server;

// server/ClientHandler.java

import com.alex.protocol.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private String username;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = (Message) in.readObject();

                switch (message.getType()) {
                    case "login":
                        handleLogin(message);
                        break;
                    case "chat":
                        handleChat(message);
                        break;
                    case "logout":
                        handleLogout();
                        return;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            handleLogout();
        } finally {
            close();
        }
    }

    private void handleLogin(Message message) {
        this.username = message.getSender();

        // 检查用户名是否已存在
        if (ChatServer.isUsernameExists(username)) {
            Message response = new Message("login", "系统", "用户名已存在，请重新输入");
            response.setType("login_failed");
            sendMessage(response);
            return;
        }

        // 登录成功
        Message response = new Message("login", "系统", "登录成功");
        response.setType("login_success");
        sendMessage(response);

        // 添加到客户端列表
        ChatServer.addClient(username, this);
    }

    private void handleChat(Message message) {
        ChatServer.broadcast(message);
    }

    private void handleLogout() {
        if (username != null) {
            ChatServer.removeClient(username);
        }
    }

    public void sendMessage(Message message) {
        try {
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
