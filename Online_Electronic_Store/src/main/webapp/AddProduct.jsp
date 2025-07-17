<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pack1.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="css/admin-success.css">
</head>
<body class="admin-success-bg">
    <div class="success-container">
        <%
            AdminBean abean = (AdminBean) session.getAttribute("abean");
            String msg = (String) request.getAttribute("msg");
        %>
        <h2> Ms. <%= abean.getaFname() %>, <%= msg %></h2>

        <div class="button-links">
            <a href="AddProduct.html"> Add Product</a>
            <a href="view1"> View Products</a><br><br>
            <a href="logout"> Logout</a>
        </div>
    </div>
</body>
</html>
