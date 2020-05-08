<%@ page language="java" pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="container">
   <nav class="navbar navbar-default">
      <div class="container-fluid">
         <ul class="nav navbar-nav">
            <li class="dropdown">
               <a class="dropdown-toggle" data-toggle="dropdown" href="#">Prizes
                  <span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <c:forEach items="${requestScope.allPrizes}" var="prize">
                     <c:if test="${prize==1000 || prize==40000 || prize==1000000}">
                        <c:if test="${prize<requestScope.nextPrize}">
                           <li class="answered"><a class="isDisabled" href="#"><strong>${prize}</strong></a></li>
                        </c:if>
                        <c:if test="${prize>=requestScope.nextPrize}">
                           <li class="unanswered"><a href="#"><strong>${prize}</strong></a></li>
                        </c:if>
                     </c:if>
                     <c:if test="${prize!=1000 && prize!=40000 && prize!=1000000}">
                        <c:if test="${prize<requestScope.nextPrize}">
                           <li class="answered"><a class="isDisabled" href="#">${prize}</a></li>
                        </c:if>
                        <c:if test="${prize>=requestScope.nextPrize}">
                           <li class="unanswered"><a href="#">${prize}</a></li>
                        </c:if>
                     </c:if>
                  </c:forEach>
               </ul>
            </li>
            <li><p class="navbar-text">You are playing for: ${requestScope.nextPrize}</p></li>
            <li><p class="navbar-text">Current Prize: ${sessionScope.game.currentPrize}</p></li>
            <li><p class="navbar-text">Guaranteed Prize: ${sessionScope.game.guaranteedPrize}</p></li>
         </ul>
         <c:forEach items="${requestScope.allLifelines}" var="lifeline">
            <c:if test="${sessionScope.game.lifelines.contains(lifeline)}">
               <c:if test="${lifeline.toString()=='FIFTY_FIFTY'}">
                  <a href="#" class="btn btn-danger navbar-btn navbar-right" role="button"
                     data-placement="bottom" data-trigger="focus"
                     data-toggle="popover" title="Are you sure you want to use this lifeline"
                     data-content="<a href='/game/lifelines?type=fifty-fifty'>YES</a>">FIFTY-FIFTY
                  </a>
               </c:if>
               <c:if test="${lifeline.toString()=='AUDIENCE'}">
                  <a href="#" class="btn btn-danger navbar-btn navbar-right" role="button"
                     data-placement="bottom" data-trigger="focus"
                     data-toggle="popover" title="Are you sure you want to use this lifeline"
                     data-content="<a href='/game/lifelines?type=audience'>YES</a>">AUDIENCE
                  </a>
               </c:if>
            </c:if>
            <c:if test="${!sessionScope.game.lifelines.contains(lifeline)}">
               <button class="btn btn-danger navbar-btn navbar-right" role="button" disabled>
                  <c:if test="${lifeline.toString()=='FIFTY_FIFTY'}">
                     FIFTY-FIFTY
                  </c:if>
                  <c:if test="${lifeline.toString()=='AUDIENCE'}">
                     AUDIENCE
                  </c:if>
               </button>
            </c:if>
         </c:forEach>
      </div>
   </nav>

   <h3>${sessionScope.game.playerName}, here's question for you:</h3>
   <div class="row">
      <div class="thumbnail col-sm-8 col-md-12">
         <h3>Question ${sessionScope.game.questionNumber}: ${requestScope.question.questionContent}</h3>
      </div>
   </div>
   <form action="/game/play" method="post">
      <div class="row">
         <div class="btn-group-toggle btn-group-vertical col-sm-8 col-md-12" data-toggle="buttons">
            <c:if test="${requestScope.question.answers.get(0).equals('')}">
               <label class="btn btn-answer btn-unpressed btn-block btn-lg disabled 0" for="0">
                  <input type="radio" name="answer" id="0" value="0" autocomplete="off">
                  A: ${requestScope.question.answers.get(0)}
               </label>
            </c:if>
            <c:if test="${!requestScope.question.answers.get(0).equals('')}">
               <label class="btn btn-answer btn-unpressed btn-block btn-lg 0" for="0">
                  <input type="radio" name="answer" id="0" value="0" autocomplete="off">
                  A: ${requestScope.question.answers.get(0)}
               </label>
            </c:if>
            <c:if test="${requestScope.question.answers.get(1).equals('')}">
               <label class="btn btn-answer btn-unpressed btn-block btn-lg disabled 1" for="1">
                  <input type="radio" name="answer" id="1" value="1" autocomplete="off">
                  B: ${requestScope.question.answers.get(1)}
               </label>
            </c:if>
            <c:if test="${!requestScope.question.answers.get(1).equals('')}">
               <label class="btn btn-answer btn-unpressed btn-block btn-lg 1" for="1">
                  <input type="radio" name="answer" id="1" value="1" autocomplete="off">
                  B: ${requestScope.question.answers.get(1)}
               </label>
            </c:if>
            <c:if test="${requestScope.question.answers.get(2).equals('')}">
               <label class="btn btn-answer btn-unpressed btn-block btn-lg disabled 2" for="2">
                  <input type="radio" name="answer" id="2" value="2" autocomplete="off">
                  C: ${requestScope.question.answers.get(2)}
               </label>
            </c:if>
            <c:if test="${!requestScope.question.answers.get(2).equals('')}">
               <label class="btn btn-answer btn-unpressed btn-block btn-lg 2" for="2">
                  <input type="radio" name="answer" id="2" value="2" autocomplete="off">
                  C: ${requestScope.question.answers.get(2)}
               </label>
            </c:if>
            <c:if test="${requestScope.question.answers.get(3).equals('')}">
               <label class="btn btn-answer btn-unpressed btn-block btn-lg disabled 3" for="3">
                  <input type="radio" name="answer" id="3" value="3" autocomplete="off">
                  D: ${requestScope.question.answers.get(3)}
               </label>
            </c:if>
            <c:if test="${!requestScope.question.answers.get(3).equals('')}">
               <label class="btn btn-answer btn-unpressed btn-block btn-lg 3" for="3">
                  <input type="radio" name="answer" id="3" value="3" autocomplete="off">
                  D: ${requestScope.question.answers.get(3)}
               </label>
            </c:if>
         </div>
      </div>
      <div class="btn-group">
         <button type="submit" class="btn btn-primary btn-submit" disabled>Submit Answer</button>
         <a href="#" class="btn btn-danger" role="button"
            data-placement="bottom" data-trigger="focus"
            data-toggle="popover" title="Are you sure you want to forfeit"
            data-content="<a href='/game/forfeit'>YES</a>">Forfeit
         </a>
      </div>
   </form>
</div>

<script>
   $('form').submit(function () {
      return showCorrectAnswer(this);
   });
   function showCorrectAnswer(form) {
      $(document).ready(function () {
         $("."+${requestScope.question.correctAnswerNumber}).addClass('btn-correct');
      });
      setTimeout(function() {form.submit()}, 3000);
      return false;
   }
   $(document).ready(function () {
      $('label').click(function () {
         $(this).addClass('btn-pressed').removeClass('btn-unpressed')
             .siblings().removeClass('btn-pressed').addClass('btn-unpressed');
      });
   });
   $(document).ready(function () {
      $(".btn-unpressed").click(function () {
         $(".btn-submit").prop('disabled', false);
      });
   });
   $(document).ready(function () {
      $('[data-toggle="popover"]').popover({html: true, container: 'body'});
   });
</script>

</body>
</html>