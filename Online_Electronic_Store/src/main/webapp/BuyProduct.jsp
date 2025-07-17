<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.pack1.ProductBean" %>
<%
    ProductBean p = (ProductBean) request.getAttribute("product");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Buy Product</title>
   <link rel="stylesheet" type="text/css" href="css/buy-product.css">

</head>
<body>
    <div class="buy-card">
        <h1>Buy Product</h1>

        <% if (error != null) { %>
            <p class="error-msg"><%= error %></p>
        <% } %>

      <!--  <div class="info-row"><label>ID:</label> <span><%= p.getpCode() %></span></div>
        <div class="info-row"><label>Name:</label> <span><%= p.getpName() %></span></div>
        <div class="info-row"><label>Company:</label> <span><%= p.getpCompany() %></span></div>
        <div class="info-row"><label>Price:</label> <span><%= p.getpPrice() %></span></div>
        <div class="info-row"><label>Stock:</label> <span><%= p.getpQuantity() %></span></div>   --> 


         <div class="info-row">
    <label>ID:</label>
    <input type="text" value="<%= p.getpCode() %>" readonly>
         </div>
         <div class="info-row">
    <label>Name:</label>
    <input type="text" value="<%= p.getpName() %>" readonly>
         </div>
         <div class="info-row">
    <label>Company:</label>
    <input type="text" value="<%= p.getpCompany() %>" readonly>
         </div>
         <div class="info-row">
    <label>Price:</label>
    <input type="text" value="<%= p.getpPrice() %>" readonly>
         </div>
         <div class="info-row">
    <label>Stock:</label>
    <input type="text" value="<%= p.getpQuantity() %>" readonly>
         </div>
         
         
        <form method="post" action="buyProduct" class="buy-form">
            <div class="info-row">
                <label>Quantity:</label>
                <input type="number" name="req_no" min="1" max="<%= p.getpQuantity() %>" required>
            </div>

            <input type="hidden" name="pcode" value="<%= p.getpCode() %>">
            <input type="hidden" name="pname" value="<%= p.getpName() %>">
            <input type="hidden" name="pcompany" value="<%= p.getpCompany() %>">
            <input type="hidden" name="pprice" value="<%= p.getpPrice() %>">
            <input type="hidden" name="pqty" value="<%= p.getpQuantity() %>">

            <button type="submit" class="btn">Buy</button>
        </form>
    </div>
</body>
</html>
