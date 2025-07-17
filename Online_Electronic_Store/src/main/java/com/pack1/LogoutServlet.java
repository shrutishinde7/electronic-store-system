package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		HttpSession session=req.getSession(false);
		
		
		boolean isAdmin=false,isCustomer=false;
		
		  if (session != null)
		  {
	            
	             isAdmin = session.getAttribute("abean") != null;
	             isCustomer = session.getAttribute("cbean") != null;
	             System.out.println("LogoutServlet: isAdmin=" + isAdmin + ", isCustomer=" + isCustomer);
	         
	            session.invalidate();
		  }
	            
	            String ctx = req.getContextPath();
	            
	            if (isCustomer) 
	            {
	            	res.sendRedirect(ctx + "/CustomerLogin.html");
	            } 
	            else if (isAdmin) 
	            {
	            	res.sendRedirect(ctx + "/AdminLogin.html");
	            }
		else
		{ 
			res.sendRedirect(ctx + "/Logout.jsp");
		}
    }
  }




