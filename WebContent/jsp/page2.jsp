<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página 2</title>
</head>
<body>
	<%@ include file="cabecalho.jsp" %>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<ul>
		<li>1</li>
		<li>2</li>
		<li>3</li>
	</ul>

	<a href="alomundo.jsp">Voltar</a><br/>
	<a href="page3.jsp">Proxima</a>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>