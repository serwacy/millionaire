package com.sda.controller;

import com.sda.model.ConvertedQuestion;
import com.sda.model.Game;
import com.sda.model.Question;
import com.sda.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameController", value = "/play")
public class GameController extends HttpServlet {
   private QuestionService questionService = QuestionService.getInstance();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final Game game = (Game) httpServletRequest.getSession().getAttribute("game");
      final Question question = questionService.questionPicker(game);
      final ConvertedQuestion convertedQuestion = questionService.adaptQuestion(question);

      httpServletRequest.setAttribute("question", convertedQuestion);
      httpServletRequest.getRequestDispatcher("/play.jsp").forward(httpServletRequest, httpServletResponse);
   }
}
