package com.qq.commit;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;

/**
 * Created by Administrator on 2020/6/15.
 */
public class MessageType implements Serializable{
    private String messType;

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }

    @Override
    public String toString() {
        return "MessageType{" +
                "messType='" + messType + '\'' +
                '}';
    }
}
