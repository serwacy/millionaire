package com.sda.controller;

import com.sda.model.Game;
import com.sda.model.Winning;
import com.sda.service.WinningsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EndGameController", value = "/end")
public class EndGameController extends HttpServlet {
   private WinningsService winningsService = WinningsService.getInstance();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final Game game = (Game) httpServletRequest.getSession().getAttribute("game");
      game.setActive(false);
      winningsService.addWinning(createWinning(game));
      httpServletRequest.getRequestDispatcher("/end.jsp").forward(httpServletRequest, httpServletResponse);
   }

   private Winning createWinning(final Game game){
      return Winning.builder()
              .playerName(game.getPlayerName())
              .questionNumber(game.getQuestionNumber())
              .prize(game.getCurrentPrize())
              .build();
   }
}
