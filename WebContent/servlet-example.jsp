<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlets examples</title>
</head>
<body>
	<form action="wizard" method="post">
	${msgErro != null ? msgErro : ''}
		<table width="300" cellpadding="10" align="center">
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" value="${param.nome }"></td>
			</tr>
			<tr>
				<td>Endere�o:</td>
				<td><input type="text" name="endereco" value="${param.endereco }"></td>
			</tr>
			<tr>
				<td>CPF:</td>
				<td><input type="text" name="cpf" value="${param.cpf }" maxlength="11"></td>
			</tr>
			<tr>
				<td>Data de Nasc:</td>
				<td><input type="text" name="nasc" value="${param.nasc }"
				title="campo no formato dd/mm/yyyy" maxlength="10"></td>
			</tr>
			<tr>
				<td>Data de Expedi��o:</td>
				<td><input type="text" name="exped" value="${param.exped }"
				title="campo no formato dd/mm/yyyy" maxlength="10"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enviar"/></td>
				<td><input type="reset" value="Limpar"/></td>
			</tr>
		</table>
	</form>
</body>
</html>