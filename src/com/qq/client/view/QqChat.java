package com.qq.client.view;

import javax.swing.*;

/**
 * Created by Administrator on 2020/6/13.
 */
public class QqChat extends JFrame{
    JTextArea jta;
    JTextField jtf;
    JButton jb;
    JPanel jp;
    public static void main(String[] args) {
          new QqChat("1");
    }

    public QqChat(String frinend) {
        jta = new JTextArea();
        jtf = new JTextField(15);
        jb = new JButton("发送");
        jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);

        this.add(jta,"Center");
        this.add(jp,"South");
        this.setTitle(frinend);
        this.setIconImage((new ImageIcon("E:\\JAVA\\QQ项目\\image\\qq.gif")).getImage());
        this.setSize(300,240);
        this.setVisible(true);
    }
}
