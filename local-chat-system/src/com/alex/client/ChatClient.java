package com.alex.client;

import com.alex.protocol.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String username;
    private ChatClientUI ui;
    private boolean connected = false;

    public void connect(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        connected = true;
    }

    public void login(String username, ChatClientUI ui) {
        this.username = username;
        this.ui = ui;

        Message loginMsg = new Message("login", username, "");
        sendMessage(loginMsg);

        // 启动接收消息线程
        new Thread(this::receiveMessages).start();
    }

    private void receiveMessages() {
        try {
            while (connected) {
                Message message = (Message) in.readObject();
                handleMessage(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void handleMessage(Message message) {
        switch (message.getType()) {
            case "login_success":
                ui.loginSuccess();
                break;
            case "login_failed":
                ui.loginFailed(message.getContent());
                break;
            case "chat":
                ui.appendMessage(message.toString());
                break;
            case "userList":
                ui.updateOnlineCount(message.getOnlineCount());
                break;
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

    public void sendChatMessage(String content) {
        Message chatMsg = new Message("chat", username, content);
        sendMessage(chatMsg);
    }

    public void logout() {
        connected = false;
        Message logoutMsg = new Message("logout", username, "");
        sendMessage(logoutMsg);

        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}