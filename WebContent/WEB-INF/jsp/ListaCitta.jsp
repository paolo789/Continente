<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Aggiungi Città
<br>
<form action="aggiungimodifica">
<input type="submit" name="aggiungi" value="aggiungi citta">
</form>
<br>

<table border=1>
<th>Città</th><th>Population</th><th>cancella</th><th>modifica</th>
<c:forEach items="${citta}" var="city">
    <tr><td>${city.name }</td><td>${city.population}</td>
    <td>
	<form action=cancella>
	<input type="hidden" name="identd" value=${city.id }>
	<input type="hidden" name="countrycode" value=${city.countryCode }>
	<input type="submit" name="cancella" value="cancella">
	</form>
	</td>
   <td>
	<form action=aggiungimodifica>
	<input type="hidden" name="identd" value=${city.id }>
	<input type="hidden" name="countrycode" value=${city.countryCode }>
	<input type="submit" name="modifica" value="modifica" >
	</form>
	</td>
    </tr> <!--  mostrare anche popolazione -->
</c:forEach>
</table>
<br>
<a href="listanazioni?Cont=${cont }">Back</a>
</body>
</html>