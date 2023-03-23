<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<title>Diario Di Bordo</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap')
	;
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/loginvar.css">
<meta charset="UTF-8">
</head>
<body>
	<header>
		<div class="logoname">
			<a href="${pageContext.request.contextPath}\htmlfile\welcomevar.html"
				id="logoname">Diario di bordo</a>
		</div>
		<nav>
			<ul class="menu">
				<li><a
					href="${pageContext.request.contextPath}\htmlfile\welcomevar.html">Home</a></li>
				<li><a
					href="${pageContext.request.contextPath}\view\filejsp\usersregistrationvar.jsp"
					class="linkregistrati">Registrati</a></li>
			</ul>
		</nav>
	</header>
	<div class="title">
			<h1>Accedi</h1>
			<p id="par">Comincia a tenere traccia delle tue attività!</p>
	</div>
	<div class="form_group">
		<form action="${pageContext.request.contextPath}/login" method="post">
				
					<p>Username</p>
					<input type="text" name="username" class="form_field" required>
				
		
					<p>Password</p>
					<input type="password" name="password" class="form_field" required>

				<div class="item3">
					<button type="submit" value="Login" class="item3">Accedi</button>
				</div>
		</form>
	</div>
	<div class="inline">
		<p id="space">Non sei registrato?</p>
		<a href="${pageContext.request.contextPath}/view/filejsp/usersregistration.jsp"
			id="link">Clicca qui</a>
	</div>
</body>
</html>