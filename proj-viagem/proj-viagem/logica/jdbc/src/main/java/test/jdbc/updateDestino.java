package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateDestino extends Destino {
    private final Connection status;
    private int change;

    public updateDestino(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    public void Update(Scanner in) throws SQLException {
        String sql = "UPDATE destino set preco = ?, desconto = ?, duracao = ? where id = ?";

        PreparedStatement statement = status.prepareStatement(sql);

        in.nextLine();
        System.out.println("novo preco");
        super.preco = in.nextInt();
        System.out.println("novo desconto");
        super.desconto = in.nextInt();
        System.out.println("nova duracao");
        super.duracao = in.next();
        System.out.println("the id to change");
        change = in.nextInt();


        statement.setInt(1, this.preco);
        statement.setInt(2, this.desconto);
        statement.setString(3, super.duracao);
        statement.setInt(4, this.change);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("destino atualizado");
        }
    }
}
