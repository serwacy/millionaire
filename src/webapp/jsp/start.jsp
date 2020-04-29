<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">
   <form action="/start" method="post">
      <div class="form-group">
         <label for="name">Name:</label>
         <c:if test="${sessionScope.game == null}">
            <input type="text" id="name" class="form-control" placeholder="Enter name" name="name">
         </c:if>
         <c:if test="${sessionScope.game != null}">
            <input type="text" id="name" class="form-control" placeholder="${sessionScope.game.playerName}" name="name"
            value="${sessionScope.game.playerName}">
         </c:if>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
   </form>
</div>

</body>
</html>