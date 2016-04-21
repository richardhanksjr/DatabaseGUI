<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Database GUI</title>
</head>
<body>
<div class = "container">
	<form action = "GetSQL.do" method = "POST">
		
		<textarea type="text" name="input" placeholder="Enter Query"></textarea>
		<input type = "submit" class = "submit" value = "submit"></input>
		
 </form>

    <table class = "table table-hover">
    <c:forEach items ="${headers}" var = "headerValue">
    	<th>${headerValue}</th>
    </c:forEach>
    	<c:forEach items="${colMap}" var="entry">
    		<tr>
    	 		<c:forEach items = "${entry}" var = "item">
    	 			<td>${item}</td>
    	 </c:forEach>
    	 <tr>
	</c:forEach>
	</table>
</div>	
</body>
</html>