package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;

public class readDestino extends Destino {
    private final Connection status;

    public readDestino(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    public void Read(int destino) throws SQLException {
        if (destino != 0) {
            String sql = "SELECT * FROM destino where id = ?";

            PreparedStatement statement = status.prepareStatement(sql);
            statement.setInt(1, destino);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                this.id = result.getInt(1);
                this.nome = result.getString(2);
                this.continente = result.getString(3);
                this.pais = result.getString(4);
                this.preco = result.getInt(5);
                this.desconto = result.getInt(6);
                this.preco_desconto = result.getInt(7);
                this.duracao = result.getString(8);

                String out = "Destino #%d: %s - %s - %s | %d - %d - %d - %s";
                System.out.println(String.format(out, this.id, this.nome, this.continente, this.pais, this.preco,
                        this.desconto, this.preco_desconto, this.duracao));
            }

        } else {
            String sql = "SELECT * FROM destino";

            Statement statement = status.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                this.id = result.getInt(1);
                this.nome = result.getString(2);
                this.continente = result.getString(3);
                this.pais = result.getString(4);
                this.preco = result.getInt(5);
                this.desconto = result.getInt(6);
                this.preco_desconto = result.getInt(7);
                this.duracao = result.getString(8);

                String out = "Destino #%d: %s - %s - %s | %d - %d - %d - %s";
                System.out.println(String.format(out, this.id, this.nome, this.continente, this.pais, this.preco,
                        this.desconto, this.preco_desconto, this.duracao));
                System.out.println("---------------------------------------------");
            }
        }
    }
}
