<%--
  Created by IntelliJ IDEA.
  pl.coderslab.utils.User: bartosz
  Date: 02.02.2021
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/header.jsp" %>
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="<c:url value="/user/add"/> " class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>


    <div class="card shadow m-auto">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Lista użytkowników</h6>
        </div>
                <table class="table">
                    <td><b>lp</b></td>
                    <td><b>Nazwa użytkownika</b></td>
                    <td><b>Email</b></td>
                    <td><b>Akcja</b></td>
                    <c:forEach items="${users}" var="user" varStatus="count">
                        <tr>
                            <td>${count.index+1}</td>
                            <td>${user.userName}</td>
                            <td>${user.email}</td>
                            <td>
                                <a href="<c:url value="/user/delete?id=${user.id}"/>"> Usuń </a>
                                <a href="<c:url value="/user/edit?id=${user.id}"/>"> Edycja </a>
                                <a href="<c:url value="/user/read?id=${user.id}"/>"> Pokaż </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
        </div>
    </div>
</div>
<%@include file="/footer.jsp" %>