<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expression Language</title>
</head>
<body>
	
	<form action="el2.jsp" method="post">
		Nome: <input name="nome" value="${param['nome']}"/> <br/>
		Endereço: <input name="endereco" value="${param['endereco']}"/> <br/>
		Versão: <input name="versao" value="${param['versao']}"/> <br/>
		Musicas: <input type="checkbox" name="musicas" value="Samba"/> Samba<br/>
		<input type="checkbox" name="musicas" value="Forro"/> Forró<br/>
		<input type="checkbox" name="musicas" value="mpb"/> MPB<br/>
	
		<input type="submit" value="Enviar"/>
	</form>
	
</body>
</html>