package com.uniovi.sdi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletComentarios
 */
@WebServlet("/comentarios")
public class ServletComentarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletComentarios() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String cuerpo = request.getParameter("cuerpo");

		ComentariosService cS = new ComentariosService();

		cS.setNuevoComentario(new Comentario(nombre, cuerpo));

		List<Comentario> comentarios = cS.getComentarios();

		request.getSession().setAttribute("comentarios", comentarios);

		request.setAttribute("comentarios", comentarios);
		getServletContext().getRequestDispatcher("/vista-comentarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
