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
<br>

<form action="modifica">
<c:if test="${citta != null}">
Modifica Città<br>
<input type="text" name="nomecitta" value=${citta.name }>
  <select name="country">
    <c:forEach items="${countries}" var="country">
        <option value="${country.code}" ${country.code == citta.countryCode ? 'selected' : ''}>${country.name}</option>
    </c:forEach>
</select>
<input type="text" name="district" value=${citta.district }>
<input type="text" name="population" value=${citta.population }>
<input type="hidden" name="id" value=${citta.id }><input type="submit" name="modify"> 
</c:if>
<c:if test="${citta == null}">
Aggiungi Città<br>
<input type="text" name="nomecitta">
<select name="country">
    <c:forEach items="${countries}" var="country">
        <option value="${country.code}" >${country.name}</option>
    </c:forEach>
</select>
<input type="text" name="district">
<input type="text" name="population">
<input type="submit" name="modify">
</c:if>
</form>
</body>
</html>