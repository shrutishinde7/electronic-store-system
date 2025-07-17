package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewCustomerProductDAO 
{
	 ArrayList<ProductBean>al=new ArrayList<ProductBean>();
	    
	    public ArrayList<ProductBean> retrieveProducts()
	    {
	    	try
	    	{
	    		Connection con=DBConnect.getCon();
	    		
	    		System.out.println("DAO: Opening DB connection: " + con);
	            System.out.println("DAO: Running query: SELECT * FROM product");
	    		
	    	    PreparedStatement pstm=con.prepareStatement("select * from product");
	    	   
	    	    ResultSet rs=pstm.executeQuery();
	    	    while(rs.next())
	    	    {
	    	    //	 System.out.println("DAO: Fetched product - code: " + rs.getString(1)
	            //     + ", name: " + rs.getString(2));
	    	    	
	    	    	ProductBean pb=new ProductBean();
	    	    	pb.setpCode(rs.getString(1));
	    	    	pb.setpName(rs.getString(2));
	    	    	pb.setpCompany(rs.getString(3));
	    	    	pb.setpPrice(rs.getString(4));
	    	    	pb.setpQuantity(rs.getString(5));
	    	    	
	    	    	al.add(pb);
	    	    }
	    	  //  System.out.println("DAO: Total products fetched = " + al.size());
	    	    
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
			return al;
	    	
	    }    
}
