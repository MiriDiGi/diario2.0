<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diario Di Bordo</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap')
	;
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}\css\logout.css">
</head>
<header>
	<div class="logoname">
		<a href="${pageContext.request.contextPath}\htmlfile\welcomevar.html">Diario di bordo</a>
	</div>
	<nav>
		<ul class="menu">
			<li><a href="${pageContext.request.contextPath}\htmlfile\welcomevar.html">Home</a></li>
			<li><a href="..\filejsp\usersregistrationvar.jsp">Registrati</a></li>
		</ul>
	</nav>
	<a href="..\filejsp\loginvar.jsp"><button>Accedi</button></a>
</header>
<body>
	<div class="title">
		<h1>Logout</h1>
		<p id="par">Logout effettuato con successo!</p>
		<div id="title-p">
			<p>Vuoi inserire altre attività o ricontrollare la cronologia?</p>
			<p>Accedi tramite il bottone qui sotto</p>
		</div>
	</div>
	<div class="item3">
		<a href="..\filejsp\loginvar.jsp"><button>Accedi</button></a>
	</div>
</body>
</html>