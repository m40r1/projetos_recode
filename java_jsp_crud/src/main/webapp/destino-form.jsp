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
									<li class="nav-item34">
										<a class="nav-link" href="login.html">Login</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="destino-list.jsp">Destinos_java</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="cliente-list.jsp">Clientes_java</a>
									</li>
								</ul>
							</div>
						</div>
					</nav>
				</header>
				<br>
				<div class="container col-md-5">
					<div class="card">
						<div class="card-body">
							<c:if test="${destino != null}">
								<form action="update" method="post">
							</c:if>
							<c:if test="${destino == null}">
								<form action="insert" method="post">
							</c:if>

							<caption>
								<h2>
									<c:if test="${destino != null}">
										Editar destino
									</c:if>
									<c:if test="${destino == null}">
										Novo destino
									</c:if>
								</h2>

							</caption>

							<c:if test="${destino != null}">
								<input type="hidden" name="id" value="<c:out value='${destino.id}' />" />
							</c:if>

							<fieldset class="form-group">
								<label>Nome destino</label> <input type="text" value="<c:out value='${destino.nome}' />"
									class="form-control" name="nome" required="required">
							</fieldset>

							<fieldset class="form-group">
								<label>Continente do destino</label> <input type="text"
									value="<c:out value='${destino.continente}' />" class="form-control"
									name="continente">
							</fieldset>

							<fieldset class="form-group">
								<label>pais de destino/label> <input type="text"
										value="<c:out value='${destino.pais}' />" class="form-control" name="pais">
							</fieldset>

							<fieldset class="form-group">
								<label>preco da viagem</label> <input type="text"
									value="<c:out value='${destino.preco}' />" class="form-control" name="preco">
							</fieldset>

							<fieldset class="form-group">
								<label>desconto</label> <input type="text" value="<c:out value='${destino.desconto}' />"
									class="form-control" name="desconto">
							</fieldset>

							<fieldset class="form-group">
								<label>preco com desconto</label> <input type="text"
									value="<c:out value='${destino.preco_desconto}' />" class="form-control"
									name="preco_desconto">
							</fieldset>

							<fieldset class="form-group">
								<label>duracao da viagem</label> <input type="text"
									value="<c:out value='${destino.duracao}' />" class="form-control" name="duracao">
							</fieldset>

							<button type="submit" class="btn btn-success">Salvar</button>
							</form>
						</div>
					</div>
				</div>
			</body>

		</html>