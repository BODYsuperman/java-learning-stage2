package com.alex.protocol;

// protocol/Message.java

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;      // 消息类型: login, chat, logout, userList
    private String sender;    // 发送者昵称
    private String content;   // 消息内容
    private String timestamp; // 时间戳
    private int onlineCount;  // 在线人数

    public Message() {}

    public Message(String type, String sender, String content) {
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.timestamp = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
    }

    // Getters and Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public int getOnlineCount() { return onlineCount; }
    public void setOnlineCount(int onlineCount) { this.onlineCount = onlineCount; }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender + ": " + content;
    }
}
