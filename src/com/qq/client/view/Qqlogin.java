package com.qq.client.view;


import com.qq.client.model.MyQqClient;
import com.qq.client.model.QqUser;
import com.qq.commit.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * QQ登陆界面
 * Created by Administrator on 2020/6/11.
 */
public class Qqlogin extends JFrame implements ActionListener{
    //北面
    JLabel jl1;
    //中间
    JTabbedPane jtp;//创建选项卡
    JPanel jp2, jp3, jp4;
    JLabel jp2_jl1, jp2_jl2, jp2_jl3, jp2_jl4;
    JButton jp2_jb2;
    JTextField jp2_jtf;
    JPasswordField jp2_jpf;
    JCheckBox jp2_jcb1, jp2_jcb2;
    //南面
    JPanel jp1;
    JButton jp1_jb1, jp1_jb2, jp1_jb3;

    public static void main(String[] args) {
        Qqlogin qq = new Qqlogin();
    }

    public Qqlogin() {
        //上方
        jl1 = new JLabel(new ImageIcon("E:\\JAVA\\QQ项目\\image\\tou.gif"));


        //中部
        jtp = new JTabbedPane();
        jp2 = new JPanel(new GridLayout(3, 3));
        jp3 = new JPanel(new GridLayout(3, 3));
        jp4 = new JPanel(new GridLayout(3, 3));
        jp2_jl1 = new JLabel("QQ号码", JLabel.CENTER);
        jp2_jl2 = new JLabel("QQ密码", JLabel.CENTER);
        jp2_jl3 = new JLabel("忘记密码", JLabel.CENTER);
        jp2_jl3.setForeground(Color.blue);
        jp2_jl4 = new JLabel("申请密码保护", JLabel.CENTER);
        jp2_jl4.setForeground(Color.blue);
        //JLable文本输出
        jp2_jb2 = new JButton(new ImageIcon("E:\\JAVA\\QQ项目\\image\\clear.gif"));//
        //可以触发监控的按钮输出
        jp2_jtf = new JTextField();
        jp2_jpf = new JPasswordField();
        //空格输出
        jp2_jcb1 = new JCheckBox("隐身登录");
        jp2_jcb2 = new JCheckBox("记住密码");
        //标记输出
        jp2.add(jp2_jl1);
        jp2.add(jp2_jtf);
        jp2.add(jp2_jb2);
        jp2.add(jp2_jl2);
        jp2.add(jp2_jpf);
        jp2.add(jp2_jl3);
        jp2.add(jp2_jcb1);
        jp2.add(jp2_jcb2);
        jp2.add(jp2_jl4);

        jtp.add(jp2, "QQ号码");
        jtp.add(jp3, "手机号码");
        jtp.add(jp4, "邮箱号码");

        this.add(jtp, "Center");


        //下方
        jp1 = new JPanel();
        jp1_jb1 = new JButton(new ImageIcon("E:\\JAVA\\QQ项目\\image\\denglu.gif"));
        jp1_jb1.addActionListener(new Login());
        jp1_jb2 = new JButton(new ImageIcon("E:\\JAVA\\QQ项目\\image\\quxiao.gif"));
        jp1_jb3 = new JButton(new ImageIcon("E:\\JAVA\\QQ项目\\image\\xiangdao.gif"));
        jp1.add(jp1_jb1);
        jp1.add(jp1_jb2);
        jp1.add(jp1_jb3);

        this.add(jl1, "North");
        this.add(jp1, "South");

        this.setSize(350, 240);
        //图片宽度能够达
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class Login implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == jp1_jb1) {
                QqUser user = new QqUser();
                User u = new User();

                u.setUser(jp2_jtf.getText().trim());
                System.out.println(u.getUser());
                u.setPassword(new String(jp2_jpf.getPassword()));
                System.out.println(u.getPassword());

                if (user.checkUser(u)) {
                    //密码验证失败
                    //如果user.checkUser(u)=true,创建一个新的界面
                    //并关闭已有界面
                    new QqFriend();
                    Qqlogin.this.dispose();//关闭本页面
                } else {
                    JOptionPane.showMessageDialog(Qqlogin.this,new String("用户密码错误"));
                }
            }
        }

    }
}