package com.qq.DB;

import com.mchange.v2.c3p0.ComboPooledDataSource;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
/**
 * Created by Administrator on 2020/6/16.
 */
public class DBPool {
    static private DataSource ds = null;
    private Connection con = null;
    public static Connection getCon() throws SQLException {
        ds = new ComboPooledDataSource();
        Connection con = ds.getConnection();
        return con;
    }

    public static void Close(Connection con, PreparedStatement ps, ResultSet re) throws SQLException {
        if(con!=null) {
            con.close();
        }
        if(ps!=null){
            ps.close();
        }
        if(re!=null){
            re.close();
        }
    }

}
