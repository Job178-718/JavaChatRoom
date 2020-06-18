package com.qq.server.view;

import com.qq.server.model.MyQqServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2020/6/13.
 */
public class MyServerFrame extends JFrame{
    JPanel jp1;
    JButton jb1, jb2;


    public static void main(String[] args) {
        new MyServerFrame();
    }

    public MyServerFrame() {
        jp1 = new JPanel();
        jb1 = new JButton("启动服务器");
        jb1.addActionListener(new JB1());
        jb2 = new JButton("关闭服务器");
        jb2.addActionListener(new JB2());
        jp1.add(jb1);
        jp1.add(jb2);

        this.add(jp1);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    class JB1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            new MyQqServer();

        }
    }
    class JB2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
    }
    }
}