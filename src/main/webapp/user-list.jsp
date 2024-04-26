<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Reprezentanta</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        </head>

        <body>

            <header style="text-align:center">
                <nav class="navbar-toggleable-md navbar-light bg-faded" style="background-color:black">
                    <div>
                        <a href=" " class="navbar-brand" style="text-align: center; color: white" > Reprezentanta </a>
                    </div>

                    <ul class="navbar-nav" style="text-align:center">
                
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">Lista de vehicule</h3>
                    <hr>
                  
                    <br>
                    <table class="table table-dark" >
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Marca</th>
                                <th>Model</th>
                                <th>Detalii</th>
                                <th>Pret</th>
                                <th>Actiuni</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="user" items="${listUser}">

                                <tr class="text-light bg-secondary">
                                    <td>
                                        <c:out value="${user.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.marca}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.model}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.detalii}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.pret}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${user.id}' />" class="text-primary">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.id}' />" class="text-danger">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                    <div class="container text-center">
						<hr>
						<hr>
						<hr>
                        <a href="<%=request.getContextPath()%>/new" class="btn btn-dark"><b>Adauga vehicul</b></a>
                    </div>
                </div>
            </div>
        </body>

        </html>