package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateContato extends Contato {
    private final Connection status;

    public updateContato(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    public void Create(Scanner in, Boolean set_nome, Boolean set_email, final int id) {
        if (set_email == true) {
            String sql = "UPDATE contato set email = ? where id = ?";
            PreparedStatement statement = status.prepareStatement(sql);

            System.out.println("novo email:");
            super.email = in.nextLine();

            statement.setString(1, super.email);
            statement.setInt(2, id);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("email alterado");
            }
        } else if (set_nome == true) {
            String sql = "UPDATE contato set nome = ? where id = ?";
            PreparedStatement statement = status.prepareStatement(sql);

            System.out.println("novo nome:");
            super.nome = in.nextLine();

            statement.setString(1, super.nome);
            statement.setInt(2, id);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("nome alterado");
            }
        } else {
            System.out.println("favor passar um nome ou email");
        }
    }
}
