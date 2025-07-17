<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.pack1.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="css/admin-dashboard.css">
</head>
<body>
    <div class="dashboard-container">
        <%
            AdminBean abean = (AdminBean) session.getAttribute("abean");
            String name = (abean != null) ? abean.getaFname() : "Admin";
        %>
        <h1>Welcome, Ms. <%= name %>!</h1>

        <div class="dashboard-links">
            <a href="AddProduct.html"> Add Product</a>
            <a href="view1"> View Products</a><br>
            <a href="logout"> Logout</a>
        </div>
    </div>
</body>
</html>
