<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<center><h1>
    <%
         session.invalidate();
         out.println("Logged-out Successfully<br><br>");
    %>
     <jsp:include page="index.html"/>
     
    <!-- <a href="index.html">Login Again</a><br><br> --> 
    
</body>
</html>