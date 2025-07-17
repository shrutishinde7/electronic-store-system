package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO 
{
	@SuppressWarnings("finally")
	public CustomerBean checkCustomerLogin(String cUsername,String cPassword)
    {
	 CustomerBean cbean=null;
	 Connection con=null;
	  PreparedStatement pstm = null;
	    ResultSet rs = null;
    	
    	try
    	{
    		 con=DBConnect.getCon();
    		 if (con == null || con.isClosed() || !con.isValid(5)) 
    		 {
    		        con = DBConnect.getCon(); // re-establish if needed
    	      }
    		
    		 pstm=con.prepareStatement("select * from customer where uname=? and pword=?");
    		pstm.setString(1, cUsername);
    		pstm.setString(2, cPassword);
    		 rs=pstm.executeQuery();
    		
    		if(rs.next())
    		{
    			cbean=new CustomerBean();
    			cbean.setcUserName(rs.getString("uname"));
    			cbean.setcPassword(rs.getString("pword"));
    		    cbean.setcFname(rs.getString("fname"));
    			cbean.setcLname(rs.getString("lname"));
    			cbean.setcAddress(rs.getString("addr"));
    			cbean.setcMailId(rs.getString("mid"));
    			cbean.setcPhoneNo(rs.getString("phno"));
 
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	finally 
    	{
            // Close resources in reverse order, each with its own safe try-catch
            if (rs != null) {
                try { rs.close(); } catch (Exception ignored) {}
            }
            if (pstm != null) {
                try { pstm.close(); } catch (Exception ignored) {}
            }
            if (con != null) {
                try { con.close(); } catch (Exception ignored) {}
            }
    	return cbean;
    }

    }
}
