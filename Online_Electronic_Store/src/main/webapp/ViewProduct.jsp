<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.pack1.AdminBean"%>
<%@ page import="com.pack1.CustomerBean"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.pack1.ProductBean"%>
<%@ page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product Details</title>
    <link rel="stylesheet" type="text/css" href="css/view-products.css">
</head>
<body>
    <div class="wrapper">
        <%
            AdminBean abean = (AdminBean) session.getAttribute("abean");
            CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");
            ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("ProductList");

            if (abean != null) {
        %>
            <h1>Hello Admin <%= abean.getaFname() %>,</h1>
            <h2>Here are the available products:</h2>
        <%
            } else if (cbean != null) {
        %>
            <h1>Hello <%= cbean.getcFname() %>,</h1>
            <h2>Find your perfect match :</h2>
        <%
            } else {
                response.sendRedirect("Login.jsp");
                return;
            }

            if (al == null || al.isEmpty()) {
        %>
            <p class="message">No products available.</p>
        <%
            } else {
        %>
            <table>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Company</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
        <%
                for (ProductBean pb : al) {
        %>
                    <tr>
                        <td><%= pb.getpCode() %></td>
                        <td><%= pb.getpName() %></td>
                        <td><%= pb.getpCompany() %></td>
                        <td><%= pb.getpPrice() %> rs</td>
                        <td><%= pb.getpQuantity() %></td>
                        <td>
                            <%
                                if (abean != null) {
                            %>
                                    <a href="edit?pcode=<%= pb.getpCode() %>" class="btn edit">Edit</a>
                                    <a href="delete?pcode=<%= pb.getpCode() %>" class="btn delete">Delete</a>
                            <%
                                } else {
                            %>
                                    <a href="buyProduct?pcode=<%= pb.getpCode() %>" class="btn buy">Buy</a>
                            <%
                                }
                            %>
                        </td>
                    </tr>
        <%
                }
        %>
                </tbody>
            </table>
        <%
            }
        %>
        <br>
        <a href="logout" class="logout-link">Logout</a>
    </div>
</body>
</html>
