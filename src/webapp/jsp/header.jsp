<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
   <title>Millionaire Game</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <style>
      .btn-unpressed {
         background-color: #2961d9;
         color: #000000;
         border-color: black;
      }
      .btn-pressed {
         background-color: #d4a120;
         color: #000000;
         border-color: black;
      }
   </style>
</head>

<body>
<nav class="navbar navbar-inverse">
   <div class="container-fluid">
      <div class="navbar-header">
         <a class="navbar-brand" href="#">Who wants to be a Millionaire</a>
      </div>
      <ul class="nav navbar-nav">
         <li><a href="/best">Best scores</a></li>
         <c:if test="${sessionScope.game.active}">
            <li><a href="/continue">Continue</a></li>
            <li><a href="/start">New game</a></li>
         </c:if>
         <c:if test="${!sessionScope.game.active}">
            <li><a href="/start">Start</a></li>
         </c:if>
      </ul>
   </div>
</nav>