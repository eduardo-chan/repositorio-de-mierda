<%--
  Created by IntelliJ IDEA.
  User: CA2-PC-
  Date: 05/07/2022
  Time: 03:24 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <% //leer y manipular datos, y hacer iteraciones %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <% //dar formato a las cadenas %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>

<html>
<head>
    <title>gestión personas</title>
    <%@include file="../../template/head.jsp"%>
</head>

<body>
<jsp:include page="../../template/navbar.jsp"></jsp:include>
<h1>INDEX DE PERSONA</h1>

<div class="container mt-5">
    <div class="row">
        <div class="col-12"> <%//tiene que acabarcar el 100% del contenedor, y se divide en 12 fragmentos%>

            <c:if test="${param['result']}"> <% // %>
                <p><c:out value="${param['message']}"></c:out></p>
            </c:if>

            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-6">PERSONAS</div>
                        <div class="col-6 text-end">
                            <a href="createPerson" class="btn btn-outline-success bnt-sm">
                                Registrar personas
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">

                    <table class="table table-sm table-hover">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Perfil</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Edad</th>
                            <th scope="col">Fecha de nacimiento</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Acciones</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% // items - de donde viene la lista %>
                        <% //itera y por cada vuelta crea un person -var- y es el se irá mostrando %>
                        <c:forEach items="${personList}" var="person" varStatus="status">
                            <tr>
                                <% //c:out - desplegar información %>
                                <% //c:forEach - iteración de elementos %>
                                <th scope="row"><c:out value="${status.count}"></c:out></th>
                                <td><img src="data:image/jpeg;base64, ${person.image}" class="rounded-circle" style="width: 80px;"
                                         alt="Avatar" /></td>
                                <td><c:out value="${person.name}"></c:out></td>
                                <td><c:out value="${person.lastName}"></c:out></td>
                                <td><c:out value="${person.age}"></c:out></td>
                                <td><fmt:formatDate value="${person.birthday}" pattern="dd/MM/yyyy"/></td>
                                <td><c:out value="${person.email}"></c:out></td>
                                <td><c:out value="${person.phone}"></c:out></td>
                                <td>
                                    <a href="getPerson?id=${person.id}" class="btn btn-warning btn-small">Editar</a>


                                    <a class="btn btn-danger btn-small"
                                       data-bs-toggle="modal"
                                       data-bs-target="#deletePerson-${person.id}"
                                    >Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<c:forEach items="${personList}" var="person" varStatus="status">
    <!-- Modal -->
    <div class="modal fade" id="deletePerson-${person.id}" tabindex="-1" aria-labelledby="deletePersonLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="post" action="deletePerson">
                    <input type="hidden" name="id" id="id" value="${person.id}">
                <div class="modal-header">
                    <h5 class="modal-title" id="deletePersonLabel">Confirmar eliminación?</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ¿Está seguro de eliminar a: <c:out value="${person.name} "></c:out><c:out value="${person.lastName}"></c:out>? UnU
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cesar</button>
                    <button type="submit" class="btn btn-primary">Confirmar</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</c:forEach>

<jsp:include page="../../template/footer.jsp"></jsp:include>
</body>
</html>


<%//do get muesta los dATOS EN LA URL, así que no, por do post%>