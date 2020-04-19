<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <title>Milionerzy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Milionerzy</a>
        </div>
        <c:if test="${sessionScope.started}">
            <ul class="nav navbar-nav">
                <li><a href="/continue">Kontynuuj</a></li>
                <li><a href="/best">Najlepsze wyniki</a></li>
                <li><a href="/start">Nowa gra</a></li>
            </ul>
        </c:if>

        <c:if test="${!sessionScope.started}">
            <ul class="nav navbar-nav">
                <li><a href="/best">Najlepsze wyniki</a></li>
                <li><a href="/start">Start</a></li>
            </ul>
        </c:if>
    </div>
</nav>