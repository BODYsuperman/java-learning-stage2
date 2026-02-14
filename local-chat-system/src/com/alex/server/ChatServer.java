package com.alex.server;


import com.alex.protocol.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    private static final int PORT = 8888;
    // 存储所有在线的客户端处理器
    private static ConcurrentHashMap<String, ClientHandler> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("聊天服务器启动在端口: " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("新客户端连接: " + socket.getInetAddress().getHostAddress());

                ClientHandler clientHandler = new ClientHandler(socket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 广播消息给所有在线用户
    public static void broadcast(Message message) {
        for (ClientHandler client : clients.values()) {
            client.sendMessage(message);
        }
    }

    // 广播在线用户列表
    public static void broadcastUserList() {
        Message userListMsg = new Message();
        userListMsg.setType("userList");
        userListMsg.setOnlineCount(clients.size());

        // 将在线用户列表转换为字符串
        StringBuilder userList = new StringBuilder();
        for (String username : clients.keySet()) {
            userList.append(username).append(",");
        }
        userListMsg.setContent(userList.toString());

        broadcast(userListMsg);
    }

    // 添加客户端
    public static void addClient(String username, ClientHandler handler) {
        clients.put(username, handler);
        broadcastUserList();

        // 广播用户加入消息
        Message joinMsg = new Message("chat", "系统", username + " 加入了聊天室");
        broadcast(joinMsg);
    }

    // 移除客户端
    public static void removeClient(String username) {
        clients.remove(username);
        broadcastUserList();

        // 广播用户离开消息
        Message leaveMsg = new Message("chat", "系统", username + " 离开了聊天室");
        broadcast(leaveMsg);
    }

    // 检查用户名是否已存在
    public static boolean isUsernameExists(String username) {
        return clients.containsKey(username);
    }
}
