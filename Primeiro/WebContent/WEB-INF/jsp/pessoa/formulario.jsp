<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="save" >
		<fieldset>
			<legend>Salvar Produto</legend>
			<label for="Nome">Nome: </label>
			<input id="nome" type="text" name="pessoa.nome" value="${pessoa.nome}"/>
			
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
	<div id="erros">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li>${error.message}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>