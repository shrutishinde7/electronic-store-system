package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateCustomerProduct")
public class UpdateCustomerProductServlet extends HttpServlet
{
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        HttpSession session = req.getSession(false);
	        if (session == null) {
	            req.setAttribute("msg", "Session expired.");
	            req.getRequestDispatcher("CustomerLogin.html").forward(req, res);
	            return;
	        }
	        
	        String pcode = req.getParameter("pcode");
	        String price = req.getParameter("pprice");
	        String qty = req.getParameter("pqty");
	        String reqno = req.getParameter("reqno");

	        CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");

	        UpdateProductServletDAO dao = new UpdateProductServletDAO();
	        double amount = dao.updateProductAndOrder(pcode, price, qty, reqno, cbean.getcUserName());

	        if (amount > 0) 
	        {
	            req.setAttribute("amount", amount);
	            req.getRequestDispatcher("OrderConfirmed.jsp").forward(req, res);
	        } 
	        else
	        {
	            req.setAttribute("msg", "Order failed. Try again.");
	            req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
	        }
	    }
}
