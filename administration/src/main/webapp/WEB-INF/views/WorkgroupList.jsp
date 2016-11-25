<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- liste des utiilsateurs qui sont déjà présents dans la base -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/css/test.css" />
<title>Liste workgroup</title>
</head>

<style media="screen" type="text/css">
body {
	background-color: #d0f4ef;
	background-image: url("..resources/form/images/logo.png");
}
th {
	background-color: #4CAF50;
	color: white;
}
tr:hover {
	background-color: #f5f5f5;
}
</style>
<body>

	<div id="bloc">
		<div align="left">
			<h1 align="left">Liste des workgroups</h1>
			<hr>

			<h2>
				<a href="newWorkgroup">Créer nouveau workgroup</a>
			</h2>

			<table border="1">
				<tr>
					<th>Name</th>
					<th>Speciality</th>
					<th>Description</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="workgroup" items="${workgroupList}"
					varStatus="status">
					<tr>
						<td>${workgroup.name}</td>
						<td>${workgroup.speciality}</td>
						<td>${workgroup.description}</td>
						<td><a href="modifier?id=${workgroup.id}">Modifier</a>
							&nbsp;&nbsp; <a href="supprimer?id=${workgroup.id}">Supprimer</a>
							&nbsp;&nbsp; <a href="administration/addCollaborator">Ajouter Collaborateur</a>
						</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
