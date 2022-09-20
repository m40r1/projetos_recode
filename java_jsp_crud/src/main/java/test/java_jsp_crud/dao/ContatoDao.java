package test.java_jsp_crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import test.java_jsp_crud.model.Contato;

public class ContatoDao {
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

	public void insertContato(Contato contato) {
		final String sql = "INSERT INTO contato (nome,email) VALUES (?,?)";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Contato selectContato(int id) {
		final String sql = "SELECT * FROM contato where id = ?";
		Contato contato = null;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				final String nome = rs.getString(2);
				final String email = rs.getString(3);
				contato = new Contato(nome, email)
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return contato;
	}

	public java.util.List<Contato> selectAllContatos() {
		java.util.List<Contato> contatos = new java.util.ArrayList<>();
		final String sql = "SELECT * FROM contato";

		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				final int id = rs.getInt(1);
				final String nome = rs.getString(2);
				final String email = rs.getString(3);
				contatos.add(new Cliente(id, nome, email));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return contatos;
	}

	public boolean deleteContato(int id) throws SQLException {
		boolean rowDeleted;
		final String sql = "DELETE FROM contato WHERE id = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateContatoNome(Contato contato) {
		boolean rowUpdated = false;
		String sql = "UPDATE contato set nome = ? where id = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, contato.getNome());
			statement.setInt(2, contato.getId());
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rowUpdated;
	}

	public boolean updateContatoEmail(Contato contato) {
		boolean rowUpdated = false;
		String sql = "UPDATE contato set email = ? where id = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setBoolean(1, contato.getEmail());
			statement.setInt(2, contato.getId());
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
