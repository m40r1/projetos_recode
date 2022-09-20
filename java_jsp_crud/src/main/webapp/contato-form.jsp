<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<html>

			<head>
				<title>Tantrum</title>

				<link rel="stylesheet"
					href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
					integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
					crossorigin="anonymous">
			</head>

			<body>

				<header>
					<nav class="navbar navbar-expand-sm navbar-dark bg-black">
						<div class="container-fluid">
							<a class="navbar-brand text-danger" href="#">Tantrum</a> <button
								class="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse"
								data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId"
								aria-expanded="false" aria-label="Toggle navigation"><span
									class="navbar-toggler-icon"></span></button>
							<div class="collapse navbar-collapse" id="collapsibleNavId">
								<ul class="navbar-nav me-auto mt-1 mt-lg-0">
									<li class="nav-item active">
										<a class="nav-link" href="home.html">Home
											<span class="visually-hidden">(current)</span></a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="destinos.html">Destinos</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="promo.html">Promoções</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="contato.html">Contato</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="login.html">Login</a>
									</li>
									<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Destinos</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="destinos.html">Destinos</a>
									<a class="dropdown-item" href="destino-form.jsp">Formulario
										Destino</a> <!-- <div class="dropdown-divider"></div> -->
									<a class="dropdown-item" href="destino-list.jsp">Listagem
										destinos</a>
								</div>
							</li>
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Clientes</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="#"></a> <a class="dropdown-item"
										href="cliente-list.jsp">list-clientes</a>
									<div class="dropdown-divider"></div><a class="dropdown-item"
										href="cliente-form.jsp">cadastro
										cliente</a>
								</div>
							</li>
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Contatos</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="#"></a> <a class="dropdown-item"
										href="cliente-list.jsp">list-contatos</a>
									<div class="dropdown-divider"></div><a class="dropdown-item"
																				  href="cliente-form.jsp">cadastro
										contato</a>
								</div>
							</li>
				</li>
								</ul>
							</div>
						</div>
					</nav>
				</header>
				<br>
				<div class="container col-md-5">
					<div class="card bg-black text-danger">
						<div class="card-body">
							<c:if test="${contato != null}">
								<form action="update" method="post">
							</c:if>
							<c:if test="${contato == null}">
								<form action="insert" method="post">
							</c:if>

							<caption>
								<h2>
									<c:if test="${contato != null}">
										Editar contato
									</c:if>
									<c:if test="${contato == null}">
										Novo contato
									</c:if>
								</h2>

							</caption>

							<c:if test="${contato != null}">
								<input type="hidden" name="id" value="<c:out value='${contato.id}' />" />
							</c:if>

							<fieldset class="form-group">
								<label>Nome contato</label> <input type="text" value="<c:out value='${contato.nome}' />"
									class="form-control" name="nome" required="required">
							</fieldset>

							<fieldset class="form-group">
								<label>Email do contato</label> <input type="text"
									value="<c:out value='${contato.email}' />" class="form-control" name="email">
							</fieldset>

							<button type="submit" class="btn btn-danger">Salvar</button>
							</form>
						</div>
					</div>
				</div>
			</body>

		</html>
