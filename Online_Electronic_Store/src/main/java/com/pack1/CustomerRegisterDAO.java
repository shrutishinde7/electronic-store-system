package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerRegisterDAO
{
    public static boolean register(String cuname, String cpword, String cfname, String clname,
            String caddr, String cmid, String cphno) {
boolean status = false;

try {
Connection con = DBConnect.getCon();
PreparedStatement ps = con.prepareStatement(
"INSERT INTO customer (uname, pword, fname, lname, addr,mid, phno) VALUES (?, ?, ?, ?, ?, ?, ?)"
);
ps.setString(1, cuname);
ps.setString(2, cpword);
ps.setString(3, cfname);
ps.setString(4, clname);
ps.setString(5, caddr);
ps.setString(6, cmid);
ps.setString(7, cphno);

int rowCount = ps.executeUpdate();
if(rowCount>0)
	{
	status = true;
	}

} 
catch (Exception e) 
{
e.printStackTrace();
}

return status;
}
    
}


