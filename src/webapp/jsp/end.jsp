<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">
   <div class="alert alert-info">
      You have won: <strong>${sessionScope.game.currentPrize} PLN</strong>
   </div>
</div>
</body>
</html>