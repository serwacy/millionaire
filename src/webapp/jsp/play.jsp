<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">

   Hej, ${sessionScope.game.playerName}. Oto kolejne pytanie ! <br />
   ${requestScope.question}

</div>

</body>
</html>