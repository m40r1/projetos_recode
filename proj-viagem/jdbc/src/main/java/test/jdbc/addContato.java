package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class addContato extends Contato {
    private final Connection status;

    public addContato(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    public void Create(Scanner in) throws SQLException {

        String sql = "INSERT INTO contato (nome,email) VALUES (?,?)";
        PreparedStatement statement = status.prepareStatement(sql);

        in.nextLine();
        System.out.println("nome do contato:");
        super.nome = in.nextLine();
        System.out.println("email do contato:");
        super.email = in.nextLine();

        statement.setString(1, super.nome);
        statement.setString(2, super.email);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("novo contato");
        }
    }
}
