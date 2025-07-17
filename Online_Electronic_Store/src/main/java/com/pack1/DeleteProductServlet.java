package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet
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
			String pcode=req.getParameter("pcode");//we will get this value from jsp (through URL rewriting)  //102
			int rowCount=new DeleteProductDAO().deleteProduct(pcode);
			if(rowCount>0)
			{
				req.setAttribute("msg", "Selected product deleted!!");
				RequestDispatcher rd=req.getRequestDispatcher("DeleteProduct.jsp");
				rd.forward(req, res);
			}
			else
			{
				throw new ServletException("Data NOT deleted");
			}
	
		}  

    }
}
