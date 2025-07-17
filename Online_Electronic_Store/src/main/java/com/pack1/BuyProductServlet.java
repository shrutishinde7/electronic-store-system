package com.pack1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buyProduct")
public class BuyProductServlet extends HttpServlet
{
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException 
	 {
	        String pcode = req.getParameter("pcode");
	        if (pcode == null)
	        {
	            res.sendRedirect("view1"); // or your product listing
	            return;
	        }

	        @SuppressWarnings("unchecked")
	        java.util.List<ProductBean> list = 
	            (java.util.List<ProductBean>) req.getSession().getAttribute("ProductList");
	        ProductBean selected = null;
	        if (list != null) {
	            for (ProductBean pb : list) 
	            {
	                if (pcode.equals(pb.getpCode()))
	                {
	                    selected = pb;
	                    break;
	                }
	            }
	        }

	        if (selected == null) 
	        {
	            res.sendRedirect("view1");
	            return;
	        }

	        req.setAttribute("product", selected);
	        req.setAttribute("req_no", (int)(System.currentTimeMillis() % Integer.MAX_VALUE));
	        req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
	    }

	@Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		String pcode = req.getParameter("pcode");
	    String pname = req.getParameter("pname");
	    String pcompany = req.getParameter("pcompany");
	    
	    double pprice = Double.parseDouble(req.getParameter("pprice"));
	    int pqty = Integer.parseInt(req.getParameter("pqty"));   //from hidden filed
	    int req_no = Integer.parseInt(req.getParameter("req_no"));  //from customer
	    
		 BuyProductServletDAO bsdao=new BuyProductServletDAO();
		 
		 boolean success = false;
		 
		try 
		{
			success = bsdao.buyProduct(pcode, pname, pcompany, pprice, pqty, req_no);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}

	        if (success) 
	        {
	        	 double totalAmount = pprice * req_no;
	        	 req.setAttribute("amount", totalAmount);
	            req.getRequestDispatcher("OrderConfirmed.jsp").forward(req, res);
	        } 
	        else 
	        {
	            req.setAttribute("error", "Unable to place order. Please try again.");
	            doGet(req,res);
	           // req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
	            return;
	        }
    }
}
