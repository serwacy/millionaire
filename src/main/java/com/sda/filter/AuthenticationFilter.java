package com.sda.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", value = "/game/*")
public class AuthenticationFilter implements Filter {

   @Override
   public void init(final FilterConfig filterConfig) throws ServletException {

   }

   @Override
   public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
      final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
      final HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;
      final Object game = httpServletRequest.getSession().getAttribute("game");
      if(game == null) {
         System.out.println("Game does not exist! Redirecting.");
         httpServletResponse.sendRedirect("/");
      } else {
         filterChain.doFilter(servletRequest, servletResponse);
      }
   }

   @Override
   public void destroy() {

   }
}