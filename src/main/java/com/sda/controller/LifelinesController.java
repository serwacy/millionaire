package com.sda.controller;

import com.sda.model.Game;
import com.sda.model.Lifeline;
import com.sda.utils.LifelineUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LifelinesController", value = "/game/lifelines")
public class LifelinesController extends HttpServlet {
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final String type = httpServletRequest.getParameter("type");
      final Game game = (Game) httpServletRequest.getSession().getAttribute("game");
      if(type.equals("fifty-fifty")){
         game.getLifelines().remove(Lifeline.FIFTY_FIFTY);
         LifelineUtils.useFiftyFiftyLifeline(game.getProcessedQuestion());
         game.setUsedFiftyFifty(true);
      }
      if(type.equals("audience")){
         game.getLifelines().remove(Lifeline.AUDIENCE);
         LifelineUtils.useAudienceLifeline(game);
      }
      httpServletResponse.sendRedirect("/game/play");
   }
}
