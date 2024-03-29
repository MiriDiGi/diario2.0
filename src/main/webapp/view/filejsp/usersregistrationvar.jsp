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
	href="${pageContext.request.contextPath}/css/registrationformvar.css">
<meta charset="UTF-8">
</head>
<header>
	<div class="logoname">
		<a href="..\htmlfile\welcomevar.html">Diario di bordo</a>
	</div>
	<nav>
		<ul class="menu">
			<li><a href="..\htmlfile\welcomevar.html">Home</a></li>
		</ul>
	</nav>
	<a href="..\view\filejsp\loginvar.jsp"><button>Accedi</button></a>
</header>
<body>
	<div class="container-bg">
		<div class="container">
			<div>
				<h1>Registrati</h1>
			</div>
			<div class="grid-container">
				<form action="<%=request.getContextPath()%>/register" method="post">
					<div class="form_group field">
						<div class="item1">
							<input type="text" name="nome" placeholder="Nome"
								class="form_field" required> <span class="focus-border"></span>
						</div>
						<div class="item2">
							<input type="text" name="cognome" placeholder="Cognome"
								class="form_field" required> <span class="focus-border"></span>
						</div>
						<div class="item1">
							<input type="text" name="username" placeholder="Username"
								class="form_field" required> <span class="focus-border"></span>
						</div>
						<div class="item3">
							<input type="email" name="email" placeholder="Email"
								class="form_field" required> <span class="focus-border"></span>
						</div>
						<!--   <div class="item4">
                                  <input type="text" name="role" placeholder="Ruolo" class="form_field" required>
                              </div>  -->
						<div class="item5">
							<input type="password" name="password" placeholder="Password"
								class="form_field" required>
						</div>
						<div class="item6">
							<button type="submit" value="Submit" class="item3">Registrati!</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>