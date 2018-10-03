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
Cerca città
<form action="ricercacitta">
<input type="text" name="cercacitta"><input type="submit">
</form>
<br>
Aggiungi Città
<br>
<form action="aggiungimodifica">
<input type="submit" name="aggiungi" value="aggiungi citta">
</form>
<br>
<table border=1>
<tr>
<th>citta</th><th>population</th><th>cancella</th><th>modifica</th>

</tr>
<c:forEach items="${listacitta}" var="citta">

<tr>
	<td>
    <p>${citta.name}</p>
	</td>
	<td>
	<p>${citta.population }
	</td>
	<td>
	<form action=cancella>
	<input type="hidden" name="identd" value=${citta.id }>
	<input type="hidden" name="countrycode" value=${citta.countryCode }>
	<input type="submit" name="cancella" value="cancella">
	</form>
	</td>
	<td>
	<form action=aggiungimodifica>
	<input type="hidden" name="identd" value=${citta.id }>
	<input type="submit" name="modifica" value="modifica" >
	</form>
	</td>
</tr>
</c:forEach>
</td>
</tr>
</table>
<br><a href="listacontinenti">Back</a><br>
</body>
</html>