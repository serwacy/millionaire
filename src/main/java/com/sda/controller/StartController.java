package com.sda.controller;

import com.sda.model.Game;
import com.sda.service.GameFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StartController", value = "/start")
public class StartController extends HttpServlet {

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      httpServletRequest.getRequestDispatcher("/start.jsp").forward(httpServletRequest, httpServletResponse);
   }

   @Override
   protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final String playerName = httpServletRequest.getParameter("name");
      final Game game = GameFactory.create(playerName);
      httpServletRequest.getSession().setAttribute("game", game);
      httpServletResponse.sendRedirect("/game/play");
   }
}
