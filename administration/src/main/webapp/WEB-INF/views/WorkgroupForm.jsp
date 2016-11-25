<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>New Workgroup</title>
</head>
<!-- workgroup form -->
<body>
	<div align="center">
		<h1>Ajout d'un nouveau workgroup</h1>
		<table>
			<form:form action="saveWorkgroup" method="post"
				modelAttribute="workgroup">
				<form:hidden path="id" />
				<tr>
					<td>Nom:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Spécialité:</td>
					<td>
					<form:select path="speciality">
						<form:option value=""/>
						<form:option value="spécialiste produit"/>
						<form:option value="gestion des publics"/>
						<form:option value="gestion des privés"/>
						<form:option value="gestion des libéraux"/>
					</form:select>
					</td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Sauvegarder"> <input type="reset" value="Annuler"></td>
				</tr>
			</form:form>
		</table>
	</div>

</body>
</html>