package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AutoresDAO;
import model.Autores;

@WebServlet(urlPatterns = {"/autores", "/create-autor", "/edit", "/update", "/delet"})
public class AutoresServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	AutoresDAO autoresDAO = new AutoresDAO();
	Autores autor = new Autores();
      
    public AutoresServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/autores":
			read(request, response);
			break;
		case "/create-autor":
			create(request, response);
			break;
		case "/edit":
			edit(request, response);
			break;
		case "/update":
			update(request, response);
			break;
		case "/delet":
			delet(request, response);
			break;
			
		default:
			response.sendRedirect("index.html");
			break;
		}
	}
	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Autores> lista = autoresDAO.getAutores();
		
		request.setAttribute("autores", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/autores/index.jsp");
		rd.forward(request, response);
	}
	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		autor.setNome(request.getParameter("nome"));
		autor.setImagem(request.getParameter("imagem"));
		autoresDAO.save(autor);
		response.sendRedirect("autores");
	
	}
	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int id = Integer.parseInt(request.getParameter("id"));
		
		autor = autoresDAO.getAutorById(id);
		
		request.setAttribute("id", autor.getId());
		request.setAttribute("nome", autor.getNome());
		request.setAttribute("imagem", autor.getImagem());
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/autores/update.jsp");
		rd.forward(request, response);
		
	}
	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		autor.setId(Integer.parseInt(request.getParameter("id")));
		autor.setNome(request.getParameter("nome"));
		autor.setImagem(request.getParameter("imagem"));
		
		autoresDAO.update(autor);
		response.sendRedirect("autores");
	}
	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		autoresDAO.deleteById(id);
		response.sendRedirect("autores");
	}
}
