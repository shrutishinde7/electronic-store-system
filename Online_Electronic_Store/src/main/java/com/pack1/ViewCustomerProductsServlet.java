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

@WebServlet("/view2")
public class ViewCustomerProductsServlet extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		

		HttpSession session=req.getSession(false);
		
		if(session==null)
		{
			req.setAttribute("msg", "session expired");
			RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
			rd.forward(req, res);
			

		}
		else
		{
			ArrayList<ProductBean> al=new ViewProductDAO().retrieveProducts();
			System.out.println("Servlet: doGet called. Session = " + session);
	        System.out.println("Servlet: Retrieved product list of size = " + al.size());
			
			session.setAttribute("ProductList", al);
			RequestDispatcher rd=req.getRequestDispatcher("ViewProduct.jsp");
			rd.forward(req, res);
		}
    }
}
