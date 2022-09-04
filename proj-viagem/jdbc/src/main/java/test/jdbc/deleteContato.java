package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteContato extends Contato {
	private final Connection status;

	public deleteContato(Connection conn) throws SQLException {
		super(conn);
		this.status = conn;
	}

	public void Delete(int id) throws SQLException {
		final String sql = "DELETE FROM contato where id = ?";

		final PreparedStatement statement = status.prepareStatement(sql);
		statement.setInt(1, id);

		final int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("contato apagado");
		}
	}
}
