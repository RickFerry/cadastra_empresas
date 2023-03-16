<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>formAlteraEmpresa
		<a href="/gerenciador/entrada?acao=ListaEmpresas">Listar Empresas</a> - 
		<a href="/gerenciador/entrada?acao=NovaEmpresaForm">Adicionar Empresa</a> - 
		<c:import url="fragmento-logout.jsp"/>
		<c:if test="${ not empty nomeEmpresa }">
			Empresa ${ nomeEmpresa } cadastrada com sucesso!
		</c:if>
		<c:if test="${ empty nomeEmpresa }">
			Nenhuma empresa cadastrada!
		</c:if>
	</body>
</html>