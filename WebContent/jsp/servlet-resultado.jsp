<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlets examples</title>
</head>
<body>
	<form>
		<table width="300" cellpadding="10" align="center">
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" disabled="disabled" value="${param.nome}"></td>
			</tr>
			<tr>
				<td>Endereço:</td>
				<td><input type="text" name="endereco" disabled="disabled" value="${param.endereco}"></td>
			</tr>
			<tr>
				<td>CPF:</td>
				<td><input type="text" name="cpf" disabled="disabled" value="${param.cpf}" ></td>
			</tr>
			<tr>
				<td>Data de Nasc:</td>
				<td><input type="text" name="nasc" disabled="disabled" value="${param.nasc}"></td>
			</tr>
		</table>
	</form>
</body>
</html>