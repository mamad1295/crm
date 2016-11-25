<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Nouvel utilisateur</title>
</head>
<!-- formulaire utilisateur à remplir, 
remarque: le champ id est invisible puisqu'il est auto-incrémenté -->
<body>
	<div align="center">
		<h1>Ajout</h1>
		<table>
			<form:form action="save" method="post" modelAttribute="user">
			<form:hidden path="id"/>
			<tr>
				<td>Login:</td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>Mot de passe:</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<input type="submit" value="Enregistrer">
					<input type="reset" value="Annuler">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
	
</body>
</html>