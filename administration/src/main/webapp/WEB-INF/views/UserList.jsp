<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- liste des utiilsateurs qui sont déjà présents dans la base -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="/css/test.css" />
        <title>Liste utilisateurs</title>
    </head>
    <body>
    
    <div id="bloc">
        <div align="left">
	        <h1 align="left">Liste des utilisateurs</h1>
	        <hr>
	        
	        <h2><a href="new">Ajouter nouvel utilisateur</a></h2>
	        
        	<table border="1">
        		<tr>
	        	<th>Numéro</th>
	        	<th>Login</th>
	        	<th>Email</th>
	        	<th>Actions</th>
	        	</tr>
				<c:forEach var="user" items="${userList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>
						<a href="modifier?id=${user.id}">Modifier</a>
						&nbsp;&nbsp;
						<a href="supprimer?id=${user.id}">Supprimer</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
       </div>
    </body>
</html>
