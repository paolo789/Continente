<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica</title>
</head>
<body>
Modifica Citt�<br>
<form action="modifica">
<c:forEach items="${citta}" var="city">
<input type="text" name="nomecitta" value=${city.name }>
<input type="text" name="countrycode" value=${city.countryCode }>
<input type="text" name="district" value=${city.district }>
<input type="text" name="population" value=${city.population }>
<input type="hidden" name="id" value=${city.id }><input type="submit" name="modify"> 
</c:forEach>
</form>

</body>
</html>