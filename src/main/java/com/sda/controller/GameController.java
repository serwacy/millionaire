package com.sda.controller;

import com.sda.model.Game;
import com.sda.model.Lifeline;
import com.sda.model.Prizes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "GameController", value = "/game/play")
public class GameController extends HttpServlet {
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final Game game = (Game) httpServletRequest.getSession().getAttribute("game");

      httpServletRequest.setAttribute("nextPrize", Prizes.PRIZES.getPrize(game.getQuestionNumber()));
      httpServletRequest.setAttribute("allPrizes", Prizes.PRIZES.getAllPrizes());
      httpServletRequest.setAttribute("allLifelines", Arrays.asList(Lifeline.FIFTY_FIFTY, Lifeline.AUDIENCE));
      httpServletRequest.setAttribute("question", game.getQuestionsList().get(game.getQuestionNumber()-1));
      httpServletRequest.getRequestDispatcher("/play.jsp").forward(httpServletRequest, httpServletResponse);
   }

   @Override
   protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final Game game = (Game) httpServletRequest.getSession().getAttribute("game");
      if(Integer.parseInt(httpServletRequest.getParameter("answer")) == game.getQuestionsList().get(game.getQuestionNumber()-1).getCorrectAnswerNumber()){
         game.setCurrentPrize(Prizes.PRIZES.getPrize(game.getQuestionNumber()));
         if(game.getQuestionNumber()==12){
            httpServletResponse.sendRedirect("/end");
            return;
         }
         game.setQuestionNumber(game.getQuestionNumber()+1);
         checkGuaranteedPrize(game);
         httpServletResponse.sendRedirect("/game/play");
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
