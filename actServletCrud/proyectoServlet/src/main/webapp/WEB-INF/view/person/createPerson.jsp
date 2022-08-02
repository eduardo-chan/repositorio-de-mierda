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
    <title>registrar persona</title>
    <%@include file="../../template/head.jsp"%>
</head>

<body>
<jsp:include page="../../template/navbar.jsp"></jsp:include>
<h1>registro de personas</h1>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">REGISTRAR PERSONA</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <% //method post - insertar eliminar o actualizar para ocultar los datos %>  <%--para que acepte multimedia enctype--%>
                            <form name="registerPerson" class="needs-validation" novalidate action="savePerson" method="post" enctype="multipart/form-data">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label for="name" class="fw-bold">Nombre</label>
                                            <input type="text" class="form-control"name="name" id="name" required>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label for="lastName" class="fw-bold">Apellido</label>
                                            <input type="text" class="form-control"name="lastName" id="lastName" required>
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
                                            <input type="number" class="form-control"name="age" id="age" required>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label for="phone" class="fw-bold">Teléfono</label>
                                            <input type="text" class="form-control"name="phone" id="phone" required>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label for="birthday" class="fw-bold">Fecha de Nacimiento</label>
                                            <input type="date" class="form-control"name="birthday" id="birthday" required>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label for="image" class="fw-bold">Foto de Perfil</label>
                                            <input type="file" class="form-control"name="image" id="image" required>
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
                                            <input type="text" class="form-control"name="email" id="email" required>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="submit" class="btn btn-success btn-sm">Registrar</button>
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
