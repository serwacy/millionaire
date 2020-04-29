package com.sda.controller;

import com.sda.service.WinningsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WinningsController", value = "/winnings")
public class WinningsController extends HttpServlet {
   private WinningsService winningsService = WinningsService.getInstance();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      httpServletRequest.setAttribute("winnings", winningsService.getAll());
      httpServletRequest.getRequestDispatcher("winnings.jsp").forward(httpServletRequest,httpServletResponse);
   }
}
