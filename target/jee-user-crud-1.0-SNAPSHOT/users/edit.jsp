<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 02.02.2021
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<!-- Page Heading -->
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="<c:url value="/user/list"/> " class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników</a>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Edytuj użytkownika</h6>
        </div>
        <div class="card-body">

            <form action="/user/edit" method="post">
                <div class="form-group">
                    <input type="hidden" name="id" value="${user.id}"/> </div>

                <div class="form-group">
                    <label for="userName">Nazwa</label>
                    <input type="text" name="userName" value="${user.userName}"
                           class="form-control" id="userName"></div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" name="email" value="${user.email}"
                    class = "form-control" id="email"></div>

                <div class="form-group">
                    <label for="password">Hasło</label>
                    <input type="text" name="password"
                    class="form-control" id="password"></div>

                <div class="form-group">
                    <button type="submit" class="btn-primary"> Zapisz</button>
                </div>

            </form>
        </div>

        <%@include file="/footer.jsp" %>
