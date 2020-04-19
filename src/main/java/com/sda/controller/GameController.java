package com.sda.controller;

import com.sda.model.Game;
import com.sda.model.Question;
import com.sda.service.JsonReader;
import com.sda.service.QuestionService;
import org.codehaus.jackson.map.ObjectMapper;

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

      final ObjectMapper mapper = new ObjectMapper();
      String question = JsonReader.readJsonFromUrl("https://opentdb.com/api.php?amount=1&difficulty=easy&type=multiple").toString();
      question = question.replace("{\"response_code\":0,\"results\":[", "");
      question = question.substring(0, question.length() - 2);

      final Question question1 = mapper.readValue(question, Question.class);

      httpServletRequest.setAttribute("question", question1);
      httpServletRequest.getRequestDispatcher("/play.jsp").forward(httpServletRequest, httpServletResponse);
   }
}
