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

                <div class="row">
                    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                    <div class="container">
                        <h3 class="text-center">Clientes</h3>
                        <hr>
                        <div class="container text-left">

                            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Novo
                                cliente</a>
                        </div>
                        <br>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Senha</th>
                                    <th>Ativo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!--   for (Todo todo: todos) {  -->
                                <c:forEach var="cliente" items="${listCliente}">

                                    <tr>
                                        <td>
                                            <c:out value="${cliente.id}" />
                                        </td>
                                        <td>
                                            <c:out value="${cliente.nome}" />
                                        </td>
                                        <td>
                                            <c:out value="${cliente.email}" />
                                        </td>
                                        <td>
                                            <c:out value="${cliente.senha}" />
                                        </td>
                                        <td>
                                            <c:out value="${cliente.ativo}" />
                                        </td>
                                        <td><a href="edit?id=<c:out value='${cliente.id}' />">Editar</a>
                                            &nbsp;&nbsp;&nbsp;&nbsp; <a
                                                href="delete?id=<c:out value='${cliente.id}' />">Deletar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <!-- } -->
                            </tbody>

                        </table>
                    </div>
                </div>
            </body>

        </html>