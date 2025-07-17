<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pack1.CustomerBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Order Confirmed</title>
    <link rel="stylesheet" type="text/css" href="css/order-confirmed.css">
</head>
<body class="order-confirmed-bg">
    <%
        double amount = (Double) request.getAttribute("amount");
        CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");
    %>

    <div class="confirmation-card">
        <h1>Hello <%= cbean.getcFname() %>!</h1>
        <p class="charge-msg">You have been charged <strong><%= amount %> Rs</strong></p>
        <p class="success-msg">Your order has been placed successfully !!!</p>

        <div class="button-group">
            <a href="view2" class="btn">View More Products</a>
            <a href="logout" class="btn logout-btn">Logout</a>
        </div>
    </div>
</body>
</html>
