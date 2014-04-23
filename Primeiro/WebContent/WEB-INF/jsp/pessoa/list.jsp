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
	<table>
		<thead>
			<tr>
				<th>Nome</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pessoaList}" var="pessoa">
				<tr>
					<td>${pessoa.nome}</td>
					<td><a href="get?idPessoa=${pessoa.idPessoa}">Editar</a></td>
					<td><a href="remove?idPessoa=${pessoa.idPessoa}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>