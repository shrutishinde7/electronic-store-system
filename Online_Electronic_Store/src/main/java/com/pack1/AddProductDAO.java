package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO 
{
   public int insertData(ProductBean pb)throws Exception
   {
	  int rowCount=0;
	   
	  try
	  {
		  Connection con=DBConnect.getCon();
  		  PreparedStatement pstm=con.prepareStatement("insert into product values(?,?,?,?,?)");
  		  pstm.setString(1, pb.getpCode());
  		  pstm.setString(2, pb.getpName());
  		  pstm.setString(3, pb.getpCompany());
  		  pstm.setString(4, pb.getpPrice());
  		  pstm.setString(5, pb.getpQuantity());
  		  rowCount=pstm.executeUpdate();
	  }
	  catch(Exception e)
	  {
		 // e.printStackTrace();
		  throw e;
	  }
	  return rowCount;
	   
   }
}
