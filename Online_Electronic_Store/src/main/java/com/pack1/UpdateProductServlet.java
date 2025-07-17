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

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet
{
	@Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
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
		String pcode=req.getParameter("pCode");//we will get this value from jsp (through URL rewriting)  //102
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
		ProductBean pb=null;
		
		Iterator<ProductBean> i=al.iterator();
		while(i.hasNext())
		{
			pb=i.next();
			if(pcode.equals(pb.getpCode()))
			{
				break;
			}
		}
		pb.setpPrice(req.getParameter("pPrice"));
		pb.setpQuantity(req.getParameter("pQty"));
		
		int rowCount=new UpdateProductDAO().UpdateProduct(pb);
		
		if(rowCount>0)
		{ 
		
			   ArrayList<ProductBean> updatedList = new ViewProductDAO().retrieveProducts();
	           session.setAttribute("ProductList", updatedList); // 💡 Update session data
	            
			 req.setAttribute("msg", "Product Details Updated!!!");
			 RequestDispatcher rd=req.getRequestDispatcher("UpdateProduct.jsp");
			 rd.forward(req, res);
			 
			 
		}
	}
}
} 

