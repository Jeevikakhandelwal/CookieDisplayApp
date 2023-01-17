package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting the MIME type
		response.setContentType("text/html");

		// Getting PrintWriter Stream to write the response
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Response</title></head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr><th>HeaderName</th><th>HeaderValue</th></tr>");

		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			Object value = request.getHeader(name);
			out.println("<tr>");
			out.println("<td>" + name + "</td>");
			out.println("<td>" + value + "</td>");
			out.println("</tr>");

		}
		out.println("</table>");
		out.println("</body></html>");

		// Closing Stream
		out.close();
	}

}
