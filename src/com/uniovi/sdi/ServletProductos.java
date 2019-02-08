package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletProductos
 */
@WebServlet("/productos")
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		ProductosService pS = new ProductosService();
		List<Producto> productosTienda  =  pS.getProductos();
//			productosTienda.add(new Producto ("zumo",null, 3));
//			productosTienda.add(new Producto ("agua",null, 1));
//			productosTienda.add(new Producto ("platano",null, 2));
//			productosTienda.add(new Producto ("chicle",null, 4));
			request.getSession().setAttribute("productosTienda", productosTienda);
		
		
		request.setAttribute("productos", productosTienda);
		getServletContext().getRequestDispatcher("/vista-productos.jsp").forward(request, response);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Tienda SDI: carrito</TITLE></HEAD>");
		out.println("<BODY>");
		out.println(productosEnHTML(productosTienda) + "<br>");
		out.println("<a href=\"index.jsp\">Volver</a></BODY></HTML>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String productosEnHTML(List<Producto> productosTienda) {
		String prod = "";
		for (Producto p : productosTienda)
			prod += "<p>" + p.getNombre() + " -- " + p.getPrecio() + " unidades"+ " </p>";
		return prod;
	}

}
