package test.java_jsp_crud.web;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.java_jsp_crud.dao.ContatoDao;
import test.java_jsp_crud.model.Contato;

@WebServlet("/contato/jsp")
public class ContatoServler extends HttpServlet {
	private ContatoDao contatoDao;

	public void init() {
		contatoDao = new ContatoDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		try {
			switch (path) {
			case "/novo_contato":
				showNewForm(request, response);
				break;
			case "/adicionar_contato":
				insertContato(request, response);
				break;
			case "/deletar_contato":
				deleteContato(request, response);
				break;
			case "/editar_contato":
				showEditForm(request, response);
				break;
			case "/atualizar_contato_nome":
				updateContatoNome(request, response);
				break;
			case "/atualizar_contato_email":
				updateContatoEmail(request, response);
				break;

			default:
				listContato(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listContato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		java.util.List<Contato> contatos = contatoDao.selectAllContatos();
		request.setAttribute("listContatos", contatos);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("contato-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final RequestDispatcher dispatcher = request.getRequestDispatcher("contato-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final Contato contato_existente = contatoDao.selectContato(id);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("contato-form.jsp");
		request.setAttribute("contato", contato_existente);
		dispatcher.forward(request, response);
	}

	private void insertContato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final String nome = request.getParameter("nome");
		final String email = request.getParameter("email");

		Contato newContato = new Contato(nome, email);
		contatoDao.insertContato(newContato);
		response.sendRedirect("list");
	}

	private void updateContatoNome(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final String nome = request.getParameter("nome");

		Contato contato = new Contato(id, nome);
		contatoDao.updateContatoNome(contato);
		response.sendRedirect("list");
	}

	private void updateContatoEmail(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final String email = request.getParameter("email");

		Contato contato = new Contato(id, email);
		contatoDao.updateContatoEmail(contato);
		response.sendRedirect("list");
	}

	private void deleteContato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		contatoDao.deleteContato(id);
		response.sendRedirect("list");
	}
}
