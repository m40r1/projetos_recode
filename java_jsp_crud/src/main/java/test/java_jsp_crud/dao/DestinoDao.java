package test.java_jsp_crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import test.java_jsp_crud.model.Destino;

public class DestinoDao {
	String dbURL = "jdbc:mariadb://localhost:3306/java";
	String username = "bot";
	String passwd = "shoppe";

	public DestinoDao() {
	}

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

	public void insertDestino(Destino destino) throws SQLException {
		final String sql = "INSERT INTO destino (nome,continente,pais,preco,desconto,preco_desconto,duracao) VALUES (?,?,?,?,?,?,?)";
		System.out.println("insert_users");
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, destino.getNome());
			statement.setString(2, destino.getContinente());
			statement.setString(3, destino.getPais());
			statement.setInt(4, destino.getPreco());
			statement.setInt(5, destino.getDesconto());
			statement.setInt(6, destino.getPreco_desconto());
			statement.setString(7, destino.getDuracao());
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Destino selectDestino(int id) {
		final String sql = "SELECT * FROM destino where id = ?";
		Destino destino = null;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			java.sql.ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				String nome = rs.getString(2);
				String continente = rs.getString(3);
				String pais = rs.getString(4);
				int preco = rs.getInt(5);
				int desconto = rs.getInt(6);
				int preco_desconto = rs.getInt(7);
				String duracao = rs.getString(8);
				destino = new Destino(nome, continente, pais, preco, desconto, preco_desconto, duracao);
			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return destino;
	}

	public java.util.List<Destino> selectAllDestinos() {
		java.util.List<Destino> destinos = new ArrayList<>();
		final String sql = "SELECT * FROM destino";

		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			java.sql.ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String continente = rs.getString(3);
				String pais = rs.getString(4);
				int preco = rs.getInt(5);
				int desconto = rs.getInt(6);
				int preco_desconto = rs.getInt(7);
				String duracao = rs.getString(8);
				destinos.add(new Destino(id, nome, continente, pais, preco, desconto, preco_desconto, duracao));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return destinos;
	}

	public boolean deleteDestino(int id) throws SQLException {
		boolean rowDeleted;
		final String sql = "DELETE FROM destino WHERE id = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateDestino(Destino destino) {
		boolean rowUpdated = false;
		final String sql = "UPDATE destino set preco = ?, desconto = ?, duracao = ? where id = ?";
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, destino.getPreco());
			statement.setInt(2, destino.getDesconto());
			statement.setString(3, destino.getDuracao());
			statement.setInt(4, destino.getId());

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
