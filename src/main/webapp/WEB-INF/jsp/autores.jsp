<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Autor</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	</head>
	<h1 class="text-center">Cadastro de Autor</h1>
	<body class="container">
		<form action="<c:url value="/autores"/>" method="POST">
			<div class="form-group">
				<label for="nome">Nome</label>
				<input id="nome" class="form-control" name="nome">
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<input id="email" class="form-control" name="email">
			</div>
			<div class="form-group">
				<label for="datanascimento">Data de Nascimento</label>
				<input id="datanascimento" class="form-control" name="datanascimento">
			</div>
			<div class="form-group">
				<label for="minicurriculo">Mini curriculo</label>
				<input id="minicurriculo" class="form-control" name="minicurriculo">
			</div>
			<input type="submit" value="Cadastrar" class="mt-2 btn-primary">
		</form>
		<table class="table table-hover table-striped table-border">
			<thead>
				<tr>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>DATA NASCIMENTO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${autores}" var="a">
				<tr>
					<td>${a.nome}</td>
					<td>${a.email}</td>
					<td>${a.datanascimento}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
