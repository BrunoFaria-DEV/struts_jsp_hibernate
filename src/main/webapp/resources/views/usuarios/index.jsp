<%@page import="java.util.List"%>
<%@page import="br.edu.cba.ifmt.Model.User" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/styles.css">
	<title>Usuarios</title>
</head>
<body>
     <html:messages id="msg" message="true">
          <c:if test="${not empty msg}">
             <div class="alert-success">
                 <c:out value="${msg}"/>
             </div>
          </c:if>
     </html:messages>

	<h1>Gestão de Usuários</h1>

	<div class="header-with-button">
		<h2>Lista de Usuários</h2>
			<html:link page="/usuariosNovo.do" styleClass="button-link">Novo</html:link>
	</div>

	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>CPF</th>
				<th>Município</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.nome}</td>
					<td>${user.email}</td>
					<td>${user.cpf}</td>
					<td>${user.city.nome}</td>
					<td>
						<html:link page="/usuariosEditar.do" paramId="id" paramProperty="id" paramName="user" styleClass="button-link">Editar</html:link>
						<form action="${pageContext.request.contextPath}/usuarios/excluir/${user.id}" method="POST" style="display:inline;">
							<button type="submit" onclick="return confirm('Deseja realmente excluir?')">Excluir</button>
						</form>
				        <form action="<c:url value='/usuariosExcluir.do'/>" method="POST" style="display:inline; margin-left: 5px;">
				            <input type="hidden" name="id" value="${user.id}">
				            <button type="submit" class="btn btn-danger btn-sm" 
				                    onclick="return confirm('Tem certeza que deseja excluir o usuário \'${user.nome}\'?');">
				                Excluir
				            </button>
				        </form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>