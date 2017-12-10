package br.edu.alomundo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AloMundo", urlPatterns = {"/alo", "/mundo"})
public class AloMundoServlet extends HttpServlet {

	private static final long serialVersionUID = -3167130738552963540L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		writer.print("<h1>Olá Mundo Servlet!</h1>");
		writer.flush();
	}
	
}
