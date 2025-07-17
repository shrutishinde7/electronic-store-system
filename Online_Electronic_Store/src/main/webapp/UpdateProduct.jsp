<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.pack1.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Action Response</title>
    <link rel="stylesheet" type="text/css" href="css/admin-response.css">
</head>
<body>
    <div class="container">
        <%
            AdminBean abean = (AdminBean) session.getAttribute("abean");
            String msg = (String) request.getAttribute("msg");

            if (abean == null) {
                response.sendRedirect("AdminLogin.html");
                return;
            }
        %>

        <h1>Hello <%= abean.getaFname() %> </h1>
        <p class="message"><%= msg %></p>

        <div class="links">
            <a href="AddProduct.html"> Add Product</a>
            <a href="view1">View Products</a>
            <a href="logout"> Logout</a>
        </div>
    </div>
</body>
</html>
