package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@127.0.0.1:1521/orcl2",
                "system",
                "newpassword"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
