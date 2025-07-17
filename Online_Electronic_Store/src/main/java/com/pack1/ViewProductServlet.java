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

@WebServlet("/view1")
public class ViewProductServlet extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		HttpSession session=req.getSession(false);
		
		if(session==null)
		{
			req.setAttribute("msg", "session expired");
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al=new ViewProductDAO().retrieveProducts();
			session.setAttribute("ProductList", al);
			RequestDispatcher rd=req.getRequestDispatcher("ViewProduct.jsp");
			rd.forward(req, res);
			

		}
    }
}
