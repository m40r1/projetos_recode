package test.java_jsp_crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import test.java_jsp_crud.model.Cliente;

public class ClienteDao {
	String dbURL = "jdbc:mariadb://localhost:3306/java";
	String username = "bot";
	String passwd = "shoppe";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(dbURL, username, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertCliente(Cliente cliente) {
		final String sql = "INSERT INTO cliente (nome,senha,ativo) VALUES (?,?,?)";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getSenha());
			statement.setBoolean(3, cliente.getAtivo());
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Cliente selectCliente(int id) {
		final String sql = "SELECT * FROM cliente where id = ?";
		Cliente cliente = null;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				final String nome = rs.getString(2);
				final String senha = rs.getString(3);
				final boolean ativo = rs.getBoolean(4);
				cliente = new Cliente(nome, senha, ativo);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return cliente;
	}

	public java.util.List<Cliente> selectAllClientes() {
		java.util.List<Cliente> clientes = new java.util.ArrayList<>();
		final String sql = "SELECT * FROM cliente";

		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				final int id = rs.getInt(1);
				final String nome = rs.getString(2);
				final String senha = rs.getString(3);
				final boolean ativo = rs.getBoolean(4);
				clientes.add(new Cliente(id, nome, senha, ativo));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return clientes;
	}

	public boolean deleteCliente(int id) throws SQLException {
		boolean rowDeleted;
		final String sql = "DELETE FROM cliente WHERE id = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateClienteNome(Cliente cliente) {
		boolean rowUpdated = false;
		String sql = "UPDATE cliente set nome = ? where id = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cliente.getNome());
			statement.setInt(2, cliente.getId());
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}

	public boolean updateClienteAtivo(Cliente cliente) {
		boolean rowUpdated = false;
		String sql = "UPDATE cliente set ativo = ? where id = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setBoolean(1, cliente.getAtivo());
			statement.setInt(2, cliente.getId());
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}

	public boolean updateClienteSenha(Cliente cliente) {
		boolean rowUpdated = false;
		String sql = "UPDATE cliente set senha = ? where id = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cliente.getSenha());
			statement.setInt(2, cliente.getId());
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
