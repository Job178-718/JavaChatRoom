package com.qq.DB;

import com.qq.commit.User;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/6/16.
 */
public class Util {
    static Connection con = null;
    static PreparedStatement ps = null;
    static User user = null;
    public static void main(String[] args) throws SQLException {
        con= DBPool.getCon();
        String sql = "select * from user where user=? and password=?";

        ps = con.prepareStatement(sql);
        ps.setString(1,"aaa");
        ps.setString(2,"aaa");
       ResultSet rs=ps.executeQuery();

            //List<User> list = new ArrayList<>();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUser(rs.getString(2));
                user.setPassword(rs.getString(3));
                System.out.println(user);
               // list.add(user);
        }

        DBPool.Close(con,ps,null);

    }
}
