package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet
{
	@Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		try
		{
			HttpSession session=req.getSession();
			if(session==null)
			{
				req.setAttribute("msg", "Session Expired");
				RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
				rd.forward(req, res);
				return;
			}
			else
			{
				ProductBean pbean=new ProductBean();
				pbean.setpCode(req.getParameter("pcode"));
				pbean.setpName(req.getParameter("pname"));
				pbean.setpCompany(req.getParameter("pcompany"));
				pbean.setpPrice(req.getParameter("pprice"));
				pbean.setpQuantity(req.getParameter("pqty"));
				
				int rowCount=new AddProductDAO().insertData(pbean);
				if(rowCount>0)
				{
					req.setAttribute("msg", "Product details added successfully");
					RequestDispatcher rd=req.getRequestDispatcher("AddProduct.jsp");
					rd.forward(req, res);
				}
				
			}
		}
		catch(Exception e)
		{
			req.setAttribute("msg", "Duplicate Product Codes are NOT Allowed");
			req.getRequestDispatcher("Error.jsp").forward(req, res);
		}
    }
}
