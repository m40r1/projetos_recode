package test.java_jsp_crud.web;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.java_jsp_crud.dao.ClienteDao;
import test.java_jsp_crud.model.Cliente;

@WebServlet("/cliente/jsp
")
public class ClienteServlet extends HttpServlet {
	private ClienteDao clienteDao;

	public void init() {
		clienteDao = new ClienteDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		try {
			switch (path) {
			case "/novo_cliente":
				showNewForm(request, response);
				break;
			case "/adicionar_cliente":
				insertCliente(request, response);
				break;
			case "/deletar_cliente":
				deleteCliente(request, response);
				break;
			case "/editar_cliente":
				showEditForm(request, response);
				break;
			case "/atualizar_cliente_nome":
				updateClienteNome(request, response);
				break;
			case "/atualizar_cliente_senha":
				updateClienteSenha(request, response);
				break;
			case "/atualizar_cliente_ativo":
				updateClienteAtivo(request, response);
				break;
			default:
				listCliente(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	private void listCliente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		java.util.List<Cliente> clientes = clienteDao.selectAllClientes();
		request.setAttribute("listCliente", clientes);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final Cliente cliente_existente = clienteDao.selectCliente(id);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("cliente", cliente_existente);
		dispatcher.forward(request, response);
	}

	private void insertCliente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final String nome = request.getParameter("nome");
		final String senha = request.getParameter("senha");
		final boolean ativo = Boolean.getBoolean(request.getParameter("ativo"));

		Cliente newCliente = new Cliente(nome, senha, ativo);
		clienteDao.insertCliente(newCliente);
		response.sendRedirect("list");
	}

	private void updateClienteNome(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final String nome = request.getParameter("nome");

		Cliente cliente = new Cliente(id, nome);
		clienteDao.updateClienteNome(cliente);
		response.sendRedirect("list");
	}

	private void updateClienteSenha(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final String senha = request.getParameter("senha");

		Cliente cliente = new Cliente(id, senha);
		clienteDao.updateClienteSenha(cliente);
		response.sendRedirect("list");
	}

	private void updateClienteAtivo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		final boolean ativo = Boolean.getBoolean(request.getParameter("ativo"));

		Cliente cliente = new Cliente(id, ativo);
		clienteDao.updateClienteAtivo(cliente);
		response.sendRedirect("list");
	}

	private void deleteCliente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		clienteDao.deleteCliente(id);
		response.sendRedirect("list");
	}
}
