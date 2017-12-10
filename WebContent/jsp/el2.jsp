<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL 2</title>
</head>
<body>

	<form action="el.jsp" method="post">
		Nome: <input name="nome" value="${param['nome']}"/> <br/>
		Endereço: <input name="endereco" value="${param['endereco']}"/> <br/>
		Versão: <input name="versao" value="${param['versao']}"/> <br/>
	
		Músicas: ${empty paramValues.musicas ? 
			'Nenhuma música foi selecionada' : paramValues.musicas[0]}
	
		<input type="submit" value="Enviar"/>
	</form>

</body>
</html>