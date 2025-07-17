package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductServletDAO 
{

    public int updateProductAndOrder(String pcode, String price, String qty, String uname, String reqno) {
        int totalAmount = 0;

        try 
        {
            Connection con = DBConnect.getCon();

            // 1. Update quantity
            PreparedStatement pst1 = con.prepareStatement(
                "UPDATE product SET pqty = pqty - ? WHERE pcode = ? AND pqty >= ?"
            );
            pst1.setInt(1, Integer.parseInt(qty));
            pst1.setString(2, pcode);
            pst1.setInt(3, Integer.parseInt(qty));
            int rowsUpdated = pst1.executeUpdate();

            if (rowsUpdated > 0) 
            {
                // 2. Insert order
                PreparedStatement pst2 = con.prepareStatement(
                    "INSERT INTO orders (req_no, uname, pcode, qty) VALUES (?, ?, ?, ?)"
                );
                pst2.setString(1, reqno);
                pst2.setString(2, uname);
                pst2.setString(3, pcode);
                pst2.setInt(4, Integer.parseInt(qty));
                pst2.executeUpdate();

                // 3. Calculate total
                totalAmount = Integer.parseInt(price) * Integer.parseInt(qty);
            }

        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return totalAmount;
    }
}

