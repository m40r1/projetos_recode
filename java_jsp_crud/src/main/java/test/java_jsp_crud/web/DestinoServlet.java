package test.java_jsp_crud.web;

import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.java_jsp_crud.dao.DestinoDao;
import test.java_jsp_crud.model.Destino;

@WebServlet("/destino/jsp/")
public class DestinoServlet extends HttpServlet {
	private DestinoDao destinoDao;

	public void init() {
		destinoDao = new DestinoDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		try {
			switch (path) {
			case "/novo_destino":
				showNewForm(request, response);
				break;
			case "/adicionar_destino":
				insertDestino(request, response);
				break;
			case "/deletar_destino":
				deteleDestino(request, response);
				break;
			case "/editar_destino":
				showEditForm(request, response);
				break;
			case "/atualizar_destino":
				updateDestino(request, response);
				break;
			default:
				listDestino(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listDestino(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		java.util.List<Destino> destinos = destinoDao.selectAllDestinos();
		request.setAttribute("listDestino", destinos);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("destino-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final RequestDispatcher dispatcher = request.getRequestDispatcher("desino-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final Destino destino_existente = destinoDao.selectDestino(id);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("destino", destino_existente);
		dispatcher.forward(request, response);
	}

	private void insertDestino(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final String nome = request.getParameter("nome");
		final String continente = request.getParameter("continente");
		final String pais = request.getParameter("pais");
		final int preco = Integer.parseInt(request.getParameter("preco"));
		final int desconto = Integer.parseInt(request.getParameter("desconto"));
		final int preco_desconto = Integer.parseInt(request.getParameter("preco_desconto"));
		final String duracao = request.getParameter("duracao");

		Destino newDestino = new Destino(id, nome, continente, pais, preco, desconto, preco_desconto, duracao);
		destinoDao.insertDestino(newDestino);
		response.sendRedirect("list");
	}

	private void updateDestino(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final int preco = Integer.parseInt(request.getParameter("preco"));
		final int desconto = Integer.parseInt(request.getParameter("desconto"));
		final String duracao = request.getParameter("duracao");

		Destino destino = new Destino(id, preco, desconto, duracao);
		destinoDao.updateDestino(destino);
		response.sendRedirect("list");
	}

	private void deteleDestino(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		destinoDao.deleteDestino(id);
		response.sendRedirect("list");
	}
}
