<%--
  Created by IntelliJ IDEA.
  User: bartosz
  Date: 02.02.2021
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/header.jsp" %>
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="<c:url value="/user/list"/> " class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników</a>
    </div>


    <div class="card shadow m-auto">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Szczegóły użytkownika</h6>
        </div>
        <table class="table">
            <tr>
                <td>ID</td><td>${user.id}</td>
            </tr>
            <tr>
                <td>Nazwa Użytkownika</td><td>${user.userName}</td>
            </tr>
            <tr>
                <td>Email</td><td>${user.email}</td>
            </tr>

            </tr>
        </table>
    </div>
</div>

<%@include file="/footer.jsp" %>