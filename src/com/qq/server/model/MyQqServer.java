package com.qq.server.model;

import com.qq.commit.MessageType;
import com.qq.commit.User;
import sun.plugin2.message.Message;
import sun.plugin2.message.Serializer;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2020/6/13.
 */
public class MyQqServer {
    private User u;
    private ObjectInputStream inputStream;

    public MyQqServer() {
        try{
            System.out.println("我是服务器在5353监听");
            //ServerSocket ss = new ServerSocket(9090);//创建连接端口

            ServerSocket ss = new ServerSocket(9090);
            Socket s = ss.accept();


            inputStream = new ObjectInputStream(s.getInputStream());

            u = (User)inputStream.readObject();

            System.out.println(u);
            MessageType m = new MessageType();
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            if(u.getPassword().equals("123456")){
                //1代表成功；
                m.setMessType("1");
                oos.writeObject(m);
            }else{
                //2代表失败；
                m.setMessType("2");
                oos.writeObject(m);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
