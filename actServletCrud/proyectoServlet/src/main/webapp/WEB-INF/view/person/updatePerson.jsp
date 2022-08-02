<%--
  Created by IntelliJ IDEA.
  User: eduardoA
  Date: 22/07/2022
  Time: 04:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>modificar persona</title>
    <%@include file="../../template/head.jsp"%>
</head>

<body>
<jsp:include page="../../template/navbar.jsp"></jsp:include>
<h1>modificación de personas</h1>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">MODIFICAR PERSONA</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <% //method post - insertar eliminar o actualizar para ocultar los datos %>
                            <form name="registerPerson" class="needs-validation" novalidate action="updatePerson" method="post">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label for="name" class="fw-bold">Nombre</label>
                                            <input type="text" class="form-control"name="name"
                                                   id="name" required value="${person.name}">
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                            <input type="hidden" name="id" id="id" value="${person.id}"/>
                                        </div>
                                        <div class="col">
                                            <label for="lastName" class="fw-bold">Apellido</label>
                                            <input type="text" class="form-control"name="lastName"
                                                   id="lastName" required value="${person.lastName}">
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label for="age" class="fw-bold">Edad</label>
                                            <input type="number" class="form-control"name="age"
                                                   id="age" required value="${person.age}">
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label for="phone" class="fw-bold">Teléfono</label>
                                            <input type="text" class="form-control"name="phone"
                                                   id="phone" required value="${person.phone}">
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label for="email" class="fw-bold">Correo electrónico</label>
                                            <input type="text" class="form-control"name="email"
                                                   id="email" required value="${person.email}">
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="submit" class="btn btn-success btn-sm">Modificar</button>
                                            <button type="button" class="btn btn-danger btn-sm">Cancelar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (() => {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        // selecciona todo lo que se encuentra dentro de la clase needs-validation y lo valida, lo marca en rojo si no está lleno
        const forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
    })()
</script>

<jsp:include page="../../template/footer.jsp"></jsp:include>
</body>
</html>
