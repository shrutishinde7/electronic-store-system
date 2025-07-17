package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/clog")
public class CustomerLoginServlet extends HttpServlet
{
	@Override
      protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
      {
		  CustomerBean cbean=new CustomerLoginDAO().checkCustomerLogin(req.getParameter("cname"), req.getParameter("cpword"));
		  if(cbean==null)
		  {
			 req.setAttribute("msg", "Invalid Customer Credentials");
			 RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
			 rd.forward(req, res);
			 
		  }
		  else
		  {
			  HttpSession session=req.getSession();
			  session.removeAttribute("abean");
			  session.setAttribute("cbean", cbean);
			  RequestDispatcher rd=req.getRequestDispatcher("CustomerHome.jsp");
		      rd.forward(req, res);
		  }
      }
}


