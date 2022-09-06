package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteCliente extends Cliente {
    private final Connection status;

    public deleteCliente(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    // deleta um usuario
    public void Delete(Scanner in) throws SQLException {
        final String sql = "DELETE FROM cliente where id = ?";

        final PreparedStatement statement = status.prepareStatement(sql);
        System.out.println("id que ira deletar");
        this.id = in.nextInt();
        statement.setInt(1, this.id);

        final int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("cliente apagado");
        }
    }
}
