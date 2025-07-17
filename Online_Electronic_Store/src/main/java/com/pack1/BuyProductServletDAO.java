package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuyProductServletDAO 
{
    public boolean buyProduct(String pcode, String pname, String pcompany,
                              double pprice, int pqty, int req_no) throws Exception 
    {
        Connection con = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        boolean success = false;
        
        try {
            con = DBConnect.getCon();
            con.setAutoCommit(false);  // begin transaction
            
            // 1. Insert order
            psInsert = con.prepareStatement(
                "INSERT INTO orders (pcode, pname, pcompany, pprice, pqty, preq_no) VALUES (?,?,?,?,?,?)");
            psInsert.setString(1, pcode);
            psInsert.setString(2, pname);
            psInsert.setString(3, pcompany);
            psInsert.setDouble(4, pprice);
            psInsert.setInt(5, pqty);   //stock
            psInsert.setInt(6, req_no); //customer request
            psInsert.executeUpdate();

            // 2. Update inventory (avoid negative stock)
            psUpdate = con.prepareStatement(
                "UPDATE product SET pqty = pqty - ? WHERE pcode = ? AND pqty >= ?");
            psUpdate.setInt(1, req_no);
            psUpdate.setString(2, pcode);
            psUpdate.setInt(3, req_no);
            
            int updatedRows = psUpdate.executeUpdate();
            if (updatedRows == 0) {
                con.rollback(); // not enough stock
                return false;
            }
            
            con.commit();
            success = true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } finally {
            // close resources in reverse order of creation
            if (psUpdate != null) try { psUpdate.close(); } catch (SQLException ignored) {}
            if (psInsert != null) try { psInsert.close(); } catch (SQLException ignored) {}
            if (con != null) try { con.setAutoCommit(true); con.close(); } catch (SQLException ignored) {}
        }
        
        return success;
    }
}
