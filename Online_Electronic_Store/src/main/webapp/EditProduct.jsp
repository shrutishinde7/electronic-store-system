<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.pack1.AdminBean"%>
<%@ page import="com.pack1.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Product</title>
    <link rel="stylesheet" type="text/css" href="css/edit-product.css">
</head>
<body>
    <div class="wrapper">
        <%
            AdminBean abean = (AdminBean) session.getAttribute("abean");
            ProductBean pb = (ProductBean) request.getAttribute("pbean");

            if (abean == null || pb == null) {
                response.sendRedirect("AdminLogin.html");
                return;
            }
        %>
        <h1>Hello <%= abean.getaFname() %> </h1>
        <h2>Edit Product: <%= pb.getpName() %></h2>

        <form action="update" method="post" class="edit-form">
            <label for="price">Product Price</label>
            <input type="text" id="price" name="pPrice" value="<%= pb.getpPrice() %>" required>

            <label for="qty">Product Quantity</label>
            <input type="text" id="qty" name="pQty" value="<%= pb.getpQuantity() %>" required>

            <input type="hidden" name="pCode" value="<%= pb.getpCode() %>">

            <button type="submit" class="update-btn">Update</button>
        </form>

        <a href="view1" class="back-link"> Back to Product List</a>
    </div>
</body>
</html>
