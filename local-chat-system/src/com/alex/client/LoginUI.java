package com.alex.client;

// client/LoginUI.java

import com.alex.server.ChatServer;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    private JTextField nicknameField;
    private JButton loginButton;
    private ChatClient client;

    public LoginUI() {
        setTitle("聊天室登录");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        client = new ChatClient();

        initUI();
    }

    private void initUI() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 标题
        JLabel titleLabel = new JLabel("群聊登录", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 120, 215));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // 输入区域
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel nicknameLabel = new JLabel("聊天昵称:");
        nicknameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        nicknameField = new JTextField(15);
        nicknameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        nicknameField.addActionListener(e -> login());

        inputPanel.add(nicknameLabel);
        inputPanel.add(nicknameField);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // 登录按钮
        loginButton = new JButton("进入聊天室");
        loginButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        loginButton.setBackground(new Color(0, 120, 215));
        loginButton.setForeground(Color.RED);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(e -> login());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void login() {
        String nickname = nicknameField.getText().trim();

        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入聊天昵称", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        loginButton.setEnabled(false);
        loginButton.setText("正在登录...");

        // 在新线程中连接服务器
        new Thread(() -> {
            try {
                client.connect("localhost", 8888);
                SwingUtilities.invokeLater(() -> {
                    ChatClientUI chatUI = new ChatClientUI(client, nickname);
                    client.login(nickname, chatUI);
                    dispose();
                });
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> {
                    loginButton.setEnabled(true);
                    loginButton.setText("进入聊天室");
                    JOptionPane.showMessageDialog(this,
                            "连接服务器失败:\n" + e.getMessage(),
                            "错误",
                            JOptionPane.ERROR_MESSAGE);
                });
            }
        }).start();
    }

    public static void main(String[] args) {
        new Thread(() -> {
            ChatServer.main(null);
        }).start();

        // 等待服务器启动
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 启动登录界面
        SwingUtilities.invokeLater(() -> {
            new LoginUI().setVisible(true);
        });
    }
}