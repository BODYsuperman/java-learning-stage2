package com.alex.d4_innerclass4;

import javax.swing.*;

public class Test3 {

    public static void main(String[] args) {

        JFrame win = new JFrame("Login system");
        JPanel panel = new JPanel();
        win.add(panel);

        JButton button = new JButton("Login");
        panel.add(button);
//
//        button.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        System.out.println("Click me. login");
//                        JOptionPane.showMessageDialog(win, "Hello!");
//                    }
//                }
//        );

        button.addActionListener(e-> JOptionPane.showMessageDialog(win, "Hello!"));

        win.setSize(400, 340);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
}
