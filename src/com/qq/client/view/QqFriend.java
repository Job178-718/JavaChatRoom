package com.qq.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 好友列表
 * Created by Administrator on 2020/6/11.
 */
public class QqFriend extends JFrame implements ActionListener,MouseListener{
    //主面板
    JPanel jpmain;
    JButton j1,j2,j3;
    //好友列表卡片
    JPanel jp1,jpf1,jpf2,jpf3;
    JButton jbf1,jbf2,jbf3;
    JScrollPane jsp1;

    //陌生人卡片
    JPanel jp1_2,jpf1_2,jpf2_2,jpf3_2;
    JButton jbf1_2,jbf2_2,jbf3_2;
    JScrollPane jsp1_2;

    //黑名单卡片
    JPanel jp1_3,jpf1_3,jpf2_3;
    JButton jbf1_3,jbf2_3,jbf3_3;
    JScrollPane jsp1_3;

    CardLayout c1 = new CardLayout();
    public static void main(String[] args) {
         QqFriend f = new QqFriend();
    }

    public QqFriend(){


        //好友卡片
        jpf1 = new JPanel(new BorderLayout());
        jbf1 = new JButton("好友列表");
        jbf1.addActionListener(this);
        jpf1.add(jbf1);

        //列表
        jpf2 = new JPanel(new GridLayout(50,1,4,4));

        JLabel []label = new JLabel[50];
        for(int i = 0;i<label.length;i++){
            label[i] = new JLabel(i+1+"",new ImageIcon("E:\\JAVA\\QQ项目\\image\\mm.jpg"),JLabel.LEFT);
            label[i].addMouseListener(this);
            jpf2.add(label[i]);
        }

        jsp1 = new JScrollPane(jpf2);
        //下部
        jpf3 = new JPanel(new GridLayout(2,1));
        jbf2 = new JButton("陌生人");
        jbf2.addActionListener(this);
        jbf3 = new JButton("黑名单");
        jbf3.addActionListener(this);
        jpf3.add(jbf2);
        jpf3.add(jbf3);



        //JPanel底层
        jp1 = new JPanel( new BorderLayout());
        jp1.add(jpf1,"North");
        jp1.add(jsp1,"Center");
        jp1.add(jpf3,"South");
        this.add(jp1);

        //陌生人卡片
        jp1_2 = new JPanel( new BorderLayout());
        //上面
        jpf1_2 = new JPanel(new GridLayout(2,1));
        jbf1_2 = new JButton("好友列表");
        jbf1_2.addActionListener(this);
        jbf2_2 = new JButton("陌生人");
        jbf2_2.addActionListener(this);
        jpf1_2.add(jbf1_2);
        jpf1_2.add(jbf2_2);

        //列表
        jpf2_2 = new JPanel(new GridLayout(20,1,4,4));
        JLabel []label_2 = new JLabel[20];
        for(int i = 0;i<label_2.length;i++){
            label_2[i] = new JLabel(i+1+"",new ImageIcon("E:\\JAVA\\QQ项目\\image\\mm.jpg"),JLabel.LEFT);
            label_2[i].addMouseListener(this);
            jpf2_2.add(label_2[i]);
        }

        jsp1_2 = new JScrollPane(jpf2_2);
        //下部
        jpf3_2 = new JPanel(new BorderLayout());

        jbf3_2 = new JButton("黑名单");
        jbf3_2.addActionListener(this);
        jpf3_2.add(jbf3_2);

        //JPanel底层

        jp1_2.add(jpf1_2,"North");
        jp1_2.add(jsp1_2,"Center");
        jp1_2.add(jpf3_2,"South");


        //黑名单
        //背景
        jp1_3 = new JPanel(new GridLayout(5,1));

        jpf1_3 = new JPanel(new GridLayout(3,1));
        jbf1_3 = new JButton("好友列表");
        jbf1_3.addActionListener(this);
        jbf2_3 = new JButton("陌生人");
        jbf2_3.addActionListener(this);
        jbf3_3 = new JButton("黑名单");
        jbf3_3.addActionListener(this);
        jpf1_3.add(jbf1_3);
        jpf1_3.add(jbf2_3);
        jpf1_3.add(jbf3_3);

        //列表
        jpf2_3 = new JPanel(new GridLayout(20,1,4,4));
        JLabel []label_3 = new JLabel[20];
        for(int i = 0;i<label_2.length;i++){
            label_3[i] = new JLabel(i+1+"",new ImageIcon("E:\\JAVA\\QQ项目\\image\\mm.jpg"),JLabel.LEFT);
            label_3[i].addMouseListener(this);
            jpf2_3.add(label_3[i]);
        }

        jsp1_3 = new JScrollPane(jpf2_3);

        jp1_3.add( jpf1_3);
        jp1_3.add(jsp1_3);
        //


        this.setLayout(c1);
        this.add(jp1,"1");
        this.add(jp1_2,"2");
        this.add(jp1_3,"3");

        this.setSize(160,500);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="好友列表"){//通过判断进行选择
          c1.show(this.getContentPane(),"1");
            /*
             c1.show();反转卡片
             */
        }else if(e.getActionCommand()=="陌生人"){
           c1.show(this.getContentPane(),"2");
        }else if(e.getActionCommand()=="黑名单"){
            c1.show(this.getContentPane(),"3");
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        //双击得到好友的编号
        if(e.getClickCount()==2){
            String friend =((JLabel)e.getSource()).getText();
            new QqChat(friend);
            System.out.println("我希望和"+friend+"聊天");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
         JLabel jl = (JLabel)e.getSource();
           jl.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jl = (JLabel)e.getSource();
        jl.setForeground(Color.black);
    }
}
