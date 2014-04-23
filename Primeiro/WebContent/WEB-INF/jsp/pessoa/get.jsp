<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="save">
		<fieldset>
			<legend>Editar Produto</legend>
			<input type="hidden" name="pessoa.idPessoa" value="${pessoa.idPessoa}" />
			<label for="nome">Nome:</label>
			<input id="nome" type="text" name="pessoa.nome" value="${pessoa.nome }"/>

			<button type="submit">Enviar</button>
		</fieldset>
	</form>
</body>
</html>