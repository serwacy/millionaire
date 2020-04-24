package com.sda.controller;

import com.sda.model.ConvertedQuestion;
import com.sda.model.Game;
import com.sda.model.Prizes;
import com.sda.model.Question;
import com.sda.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GameController", value = "/play")
public class GameController extends HttpServlet {
   private QuestionService questionService = QuestionService.getInstance();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      if(httpServletRequest.getSession().getAttribute("ended").equals(true)){
         httpServletResponse.sendRedirect("/home");
         return;
      }
      final Game game = (Game) httpServletRequest.getSession().getAttribute("game");
      final Question question = questionService.questionPicker(game);
      final ConvertedQuestion convertedQuestion = questionService.adaptQuestion(question);
      game.setProcessedQuestion(convertedQuestion);

      httpServletRequest.setAttribute("nextPrize", Prizes.PRIZES.getPrize(game.getQuestionNumber()));
      httpServletRequest.setAttribute("allPrizes", Prizes.PRIZES.getAllPrizes());
      httpServletRequest.setAttribute("question", convertedQuestion);
      httpServletRequest.getRequestDispatcher("/play.jsp").forward(httpServletRequest, httpServletResponse);
   }

   @Override
   protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final Game game = (Game) httpServletRequest.getSession().getAttribute("game");
      if(Integer.parseInt(httpServletRequest.getParameter("answer")) == game.getProcessedQuestion().getCorrectAnswerNumber()){
         game.setCurrentPrize(Prizes.PRIZES.getPrize(game.getQuestionNumber()));
         game.setQuestionNumber(game.getQuestionNumber()+1);
         checkGuaranteedPrize(game);
         httpServletResponse.sendRedirect("/play");
      } else {
         game.setCurrentPrize(game.getGuaranteedPrize());
         httpServletResponse.sendRedirect("/end");
      }
   }

   private void checkGuaranteedPrize(final Game game){
      if (game.getQuestionNumber() > 12){
         game.setGuaranteedPrize(Prizes.GUARANTEED_PRIZES.getPrize(3));
      } else if (game.getQuestionNumber() > 7){
         game.setGuaranteedPrize(Prizes.GUARANTEED_PRIZES.getPrize(2));
      } else if (game.getQuestionNumber() > 2){
         game.setGuaranteedPrize(Prizes.GUARANTEED_PRIZES.getPrize(1));
      }
   }
}
