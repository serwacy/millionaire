<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">
   <table class="table table-striped">
      <thead>
      <tr>
         <th>Player Name</th>
         <th>Ended at question number</th>
         <th>Prize</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${requestScope.winnings}" var="winning">
         <tr>
            <td>${winning.playerName}</td>
            <td>${winning.questionNumber}</td>
            <td>${winning.prize}</td>
         </tr>
      </c:forEach>
      </tbody>
   </table>
</div>

</body>
</html>