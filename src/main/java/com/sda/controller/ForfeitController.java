package com.sda.controller;

import com.sda.model.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForfeitController", value = "/game/forfeit")
public class ForfeitController extends HttpServlet {
   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      httpServletResponse.sendRedirect("/end");
   }
}
