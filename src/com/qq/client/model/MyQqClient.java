package com.qq.client.model;

import com.qq.commit.MessageType;
import com.qq.commit.User;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2020/6/13.
 * 客户端传到服务器部分
 */
public class MyQqClient {
    public boolean sendLoginfoToServer(User u){
        boolean  b = false;
        Socket s = null;
        try {

            s = new Socket("localhost", 9090);// IP地址，TCP相当于窗口:获取连接；
            System.out.println("success to server....");
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            //输出流，将数据传递出去
            oos.writeObject(u);//将数据流发送给服务器

            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());//输入流，获取数据
            MessageType mt = (MessageType) ois.readObject();//

            if (mt.getMessType().equals("1")) {
                //mt.getMessType()返回是1成功，否则失败
               b=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}
