<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Reprezentanta</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body class="p-3 mb-2 bg-secondary text-white">
            <header style="text-align:center">
                <nav class="navbar-toggleable-md navbar-light bg-faded" style="background-color:black">
                    <div>
                        <a href="" class="navbar-brand" style="text-align: center; color: white"> Reprezentanta </a>
                    </div>
                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link" style="text-align: center; color: white">Auto</a></li>               
                    </ul>
                </nav>
            </header>
            <br>
            <hr>
            <div class="container col-md-5" >
                <div class="text-white bg-dark">
                    <div class="card-body">
                        <c:if test="${user != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2 class="font-weight-light" style="text-align: center">
                                <c:if test="${user != null}">
                                    Edit Car
                                </c:if>
                                <c:if test="${user == null}">
                                    Informatii vehicul                                 
                                </c:if>
                            </h2>
                        </caption>
<br>
                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" /  class="p-3 mb-2 bg-secondary text-white">
                        </c:if>

                        <fieldset  class="p-3 mb-2 bg-secondary text-white" >
                            <b><label>Marca</label></b><input type="text" value="<c:out value='${user.marca}' />" class="form-control" name="marca" required="required">
                        </fieldset>

                        <fieldset  class="p-3 mb-2 bg-secondary text-white">
                            <b><label>Model</label></b> <input type="text" value="<c:out value='${user.model}' />" class="form-control" name="model">
                        </fieldset>

                        <fieldset class="p-3 mb-2 bg-secondary text-white">
                            <b><label>Detalii</label></b> <input type="text" value="<c:out value='${user.detalii}' />" class="form-control" name="detalii">
                        </fieldset>
                        
                        <fieldset class="p-3 mb-2 bg-secondary text-white">
                            <b><label>Pret</label></b> <input type="text" value="<c:out value='${user.pret}' />" class="form-control" name="pret">
                        </fieldset>
                        <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-light" class="btn btn-default">Salveaza</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>