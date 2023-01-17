package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Collecting request parameter details
		String name = request.getParameter("name");
		String value = request.getParameter("value");

		// Creating Cookie object at client side
		Cookie c = new Cookie(name,value);
		//c.setMaxAge(180);//Making the cookie persistent

		// To add a Cookie to the response object
		response.addCookie(c);

		// Getting PrintWriter Stream to write the response+
		PrintWriter out = response.getWriter();

		out.println("<h1 style='color:red; text-align:center'>Cookie added successfully</h1>");

		// To get the RequestDispatcher Object
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.include(request, response);

		// Closing Stream
		out.close();
	}

}
