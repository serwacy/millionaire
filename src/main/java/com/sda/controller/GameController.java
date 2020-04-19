package com.sda.controller;

import com.sda.model.Game;
import com.sda.model.Question;
import com.sda.service.JsonReader;
import com.sda.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "GameController", value = "/play")
public class GameController extends HttpServlet {
   private QuestionService questionService = QuestionService.getInstance();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final HttpSession session = httpServletRequest.getSession();
      final Game game = (Game) session.getAttribute("game");
//      final Question question = questionService.getQuestionByNumber(game.getQuestionNumber());

      final String question = JsonReader.readJsonFromUrl("https://opentdb.com/api.php?amount=1&difficulty=easy&type=multiple").toString();

      httpServletRequest.setAttribute("question", question);
      httpServletRequest.getRequestDispatcher("/play.jsp").forward(httpServletRequest, httpServletResponse);
   }
}
