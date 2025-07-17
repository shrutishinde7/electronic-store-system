package com.pack1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


	@WebServlet("/crs")
	public class CustomerRegistrationServlet extends HttpServlet
	{
		@Override
	      protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	      {
			 String uname = req.getParameter("cuname");
		        String pword = req.getParameter("cpword");
		        String fname = req.getParameter("cfname");
		        String lname = req.getParameter("clname");
		        String address = req.getParameter("caddr");
		        String mail= req.getParameter("cmid");
		        String phone = req.getParameter("cphno");
		        String sql = "INSERT INTO customer (UNAME, PWORD, FNAME, LNAME, ADDR, MID, PHNO) "
		                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		      


		        try {
		            Connection con = DBConnect.getCon();
		            PreparedStatement ps = con.prepareStatement(sql);
		    
		            
		            ps.setString(1, uname);
		            ps.setString(2, pword);
		            ps.setString(3, fname);
		            ps.setString(4, lname);
		            ps.setString(5, address);
		            ps.setString(6, mail);
		            ps.setString(7, phone);


		           int rowCount=ps.executeUpdate();

		            if(rowCount>0){
		                req.setAttribute("msg", "Registration Successful! Please login.");
		                RequestDispatcher rd = req.getRequestDispatcher("CustomerLogin.html");
		                rd.forward(req, res);
		                return;
		            } 
		            else {
		                req.setAttribute("msg", "Registration Failed.");
		                RequestDispatcher rd = req.getRequestDispatcher("CustomerRegister.html");
		                rd.forward(req, res);
		                return;
		            }

		        }
		        catch (Exception e) {
		            e.printStackTrace(); 
		            req.setAttribute("msg", "Error: " + e.getMessage());
		            RequestDispatcher rd = req.getRequestDispatcher("CustomerRegister.html");
		            rd.forward(req, res);
		            return;
		        }
		       
		    }
	      }
	


