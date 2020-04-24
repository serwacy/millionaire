package com.sda.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomePageController", value = "/")
public class HomePageController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
      httpServletRequest.setAttribute("numberOfQuestions", "infinite");
      httpServletRequest.getRequestDispatcher("/home.jsp").forward(httpServletRequest, httpServletResponse);
   }
}
