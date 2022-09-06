package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.ResultSet;
import java.sql.Statement;

public class readContato extends Contato {
	private final Connection status;

	public readContato(Connection conn) throws SQLException {
		super(conn);
		this.status = conn;
	}

	public void Read() throws SQLException {
// 		System.out.println("para ver todos os perfis digite 0");
//         System.out.println("para um perfil especifico passar sua id");
//         contato = in.nextInt();
// 		if (contato != 0) {
// 			String sql = "SELECT * FROM contato where id = ?";
//
// 			PreparedStatement statement = status.prepareStatement(sql);
// 			statement.setInt(1, contato);
// 			ResultSet result = statement.executeQuery(sql);
// //preferi mapear a query
// //para ter certeza absoluta da classe estar coerente com o banco
// //pode ser usado o valor de contato
// 			while (result.next()) {
// 				this.id = result.getInt(1);
// 				this.nome = result.getString(2);
// 				this.email = result.getString(3);
//
// 				String out = "Contato #%d: %s - %s";
// 				System.out.println(String.format(out, this.id, this.nome, this.email));
// 				System.out.println("-----------------------------------");
// 			}
// 		} else {
			String sql = "SELECT * FROM contato";

			Statement statement = status.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				this.id = result.getInt(1);
				this.nome = result.getString(2);
				this.email = result.getString(3);

				String out = "Contato #%d: %s - %s";
				System.out.println(String.format(out, this.id, this.nome, this.email));
				System.out.println("-----------------------------------");
			// }
		}
	}
}
