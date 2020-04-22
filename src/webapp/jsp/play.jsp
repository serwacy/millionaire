<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">
   <h3>${sessionScope.game.playerName}, here's question for you:</h3>
   <div class="row">
      <div class="thumbnail col-sm-8 col-md-12">
         <h3>Question ${sessionScope.game.questionNumber}: ${requestScope.question.questionContent}</h3>
      </div>
   </div>
   <div class="row">
      <div class="btn-group-toggle btn-group-vertical col-sm-8 col-md-12" data-toggle="buttons">
         <label class="btn btn-unpressed btn-block btn-lg">
            <input type="radio" name="answers" id="answerA" autocomplete="off"> A: ${requestScope.question.answerA}
         </label>
         <label class="btn btn-unpressed btn-block btn-lg">
            <input type="radio" name="answers" id="AnswerB" autocomplete="off"> B: ${requestScope.question.answerB}
         </label>
         <label class="btn btn-unpressed btn-block btn-lg">
            <input type="radio" name="answers" id="AnswerC" autocomplete="off"> C: ${requestScope.question.answerC}
         </label>
         <label class="btn btn-unpressed btn-block btn-lg">
            <input type="radio" name="answers" id="AnswerD" autocomplete="off"> D: ${requestScope.question.answerD}
         </label>
      </div>
   </div>
</div>

<script>
   $(document).ready(function () {
      $('label').click(function () {
         $(this).addClass('btn-pressed').removeClass('btn-unpressed')
             .siblings().removeClass('btn-pressed').addClass('btn-unpressed');
      });
   });
</script>

</body>
</html>