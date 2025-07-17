<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.pack1.CustomerBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Home</title>
    <link rel="stylesheet" type="text/css" href="css/customer-dashboard.css">
</head>
<body>
  <div class="page-wrapper">
    <div class="customer-container">
      <h1>
        <% CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");
           if (cbean != null) {
             out.println("Welcome " + cbean.getcFname() + "!!!");
           } else {
             response.sendRedirect("CustomerLogin.html");
             return;
           }
        %>
      </h1>

      <div class="customer-links">
        <a href="view2">View Products</a>
        <a href="logout">Logout</a>
      </div>
    </div>
  </div>
</body>

</html>
