package com.sda.controller;

import com.sda.model.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EndGameController", value = "/end")
public class EndGameController extends HttpServlet {
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final Game game = (Game) httpServletRequest.getSession().getAttribute("game");
      httpServletRequest.setAttribute("prize", game.getCurrentPrize());
      httpServletRequest.getSession().invalidate();
      httpServletRequest.getRequestDispatcher("/end.jsp").forward(httpServletRequest, httpServletResponse);
   }
}
