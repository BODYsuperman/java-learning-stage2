package com.alex.client;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClientUI extends JFrame {
    private ChatClient client;
    private String username;

    private JTextPane messageArea;
    private JTextField messageField;
    private JButton sendButton;
    private JButton logoutButton;
    private JLabel onlineCountLabel;
    private JList<String> userList;
    private DefaultListModel<String> userListModel;

    public ChatClientUI(ChatClient client, String username) {
        this.client = client;
        this.username = username;

        setTitle("群聊 - " + username);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
        setupShortcuts();
    }

    private void initUI() {
        // 主面板 - 使用BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.WHITE);

        // 顶部工具栏
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBackground(new Color(240, 242, 245));
        toolBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        JLabel titleLabel = new JLabel("群聊即时通讯");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        titleLabel.setForeground(new Color(0, 120, 215));
        toolBar.add(titleLabel);

        toolBar.add(Box.createHorizontalGlue());

        onlineCountLabel = new JLabel("在线人数: 0");
        onlineCountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        toolBar.add(onlineCountLabel);

        toolBar.addSeparator(new Dimension(20, 0));

        logoutButton = new JButton("退出登录");
        logoutButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        logoutButton.setBackground(new Color(255, 100, 100));
        logoutButton.setForeground(Color.RED);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(e -> logout());
        toolBar.add(logoutButton);

        mainPanel.add(toolBar, BorderLayout.NORTH);

        // 消息显示区域
        messageArea = new JTextPane();
        messageArea.setEditable(false);
        messageArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        messageArea.setBackground(new Color(250, 250, 250));

        // 设置消息区域的样式
        StyledDocument doc = messageArea.getStyledDocument();
        Style defaultStyle = messageArea.addStyle("Default", null);
        StyleConstants.setFontFamily(defaultStyle, "微软雅黑");
        StyleConstants.setFontSize(defaultStyle, 14);

        JScrollPane messageScrollPane = new JScrollPane(messageArea);
        messageScrollPane.setBorder(BorderFactory.createTitledBorder("聊天消息"));
        messageScrollPane.setPreferredSize(new Dimension(500, 400));

        // 用户列表
        userListModel = new DefaultListModel<>();
        userList = new JList<>(userListModel);
        userList.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        userList.setBackground(Color.WHITE);
        userList.setBorder(new EmptyBorder(5, 5, 5, 5));

        JScrollPane userScrollPane = new JScrollPane(userList);
        userScrollPane.setBorder(BorderFactory.createTitledBorder("在线用户"));
        userScrollPane.setPreferredSize(new Dimension(200, 400));

        // 消息和用户列表的水平分割
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                messageScrollPane, userScrollPane);
        splitPane.setResizeWeight(0.75);
        splitPane.setDividerSize(5);

        mainPanel.add(splitPane, BorderLayout.CENTER);

        // 底部输入区域
        JPanel inputPanel = new JPanel(new BorderLayout(10, 0));
        inputPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        inputPanel.setBackground(Color.WHITE);

        messageField = new JTextField();
        messageField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        messageField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                new EmptyBorder(8, 10, 8, 10)
        ));
        messageField.addActionListener(e -> sendMessage());

        sendButton = new JButton("发送");
        sendButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        sendButton.setBackground(new Color(0, 120, 215));
        sendButton.setForeground(Color.BLACK);
        sendButton.setFocusPainted(false);
        sendButton.setPreferredSize(new Dimension(80, 40));
        sendButton.addActionListener(e -> sendMessage());

        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void setupShortcuts() {
        // Ctrl+Enter 发送消息
        messageField.getInputMap(JComponent.WHEN_FOCUSED)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK), "sendMessage");
        messageField.getActionMap().put("sendMessage", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String content = messageField.getText().trim();
        if (content.isEmpty()) {
            return;
        }

        client.sendChatMessage(content);
        messageField.setText("");
        messageField.requestFocus();
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "确定要退出聊天室吗？", "确认退出",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            client.logout();
            dispose();

            SwingUtilities.invokeLater(() -> {
                new LoginUI().setVisible(true);
            });
        }
    }

    public void loginSuccess() {
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
            appendMessage("[" + new java.text.SimpleDateFormat("HH:mm:ss")
                    .format(new java.util.Date()) + "] 系统: 欢迎 " + username + " 加入聊天室");
        });
    }

    public void loginFailed(String reason) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this, reason, "登录失败", JOptionPane.ERROR_MESSAGE);
            dispose();
            new LoginUI().setVisible(true);
        });
    }

    public void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            try {
                StyledDocument doc = messageArea.getStyledDocument();

                // 根据消息类型设置不同样式
                if (message.contains("系统")) {
                    Style style = messageArea.addStyle("SystemMessage", null);
                    StyleConstants.setForeground(style, Color.GRAY);
                    StyleConstants.setItalic(style, true);
                    doc.insertString(doc.getLength(), message + "\n", style);
                } else {
                    doc.insertString(doc.getLength(), message + "\n", null);
                }

                // 自动滚动到底部
                messageArea.setCaretPosition(doc.getLength());
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        });
    }

    public void updateOnlineCount(int count) {
        SwingUtilities.invokeLater(() -> {
            onlineCountLabel.setText("在线人数: " + count);
        });
    }
}
