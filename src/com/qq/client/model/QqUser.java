package com.qq.client.model;

import com.qq.commit.User;

/**
 * Created by Administrator on 2020/6/15.
 */
public class QqUser {
     //验证用户
    public boolean checkUser(User u){
        return new MyQqClient().sendLoginfoToServer(u);
    }
}
