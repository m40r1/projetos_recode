package test.jdbc;

import java.sql.Connection;

import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;

public class readCliente extends Cliente {
    private final Connection status;

    public readCliente(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    public void Read(int cliente) throws SQLException {
        if (cliente != 0) {
            // unique user
            String sql = "SELECT * FROM cliente where id = ?";

            Statement statement = status.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String nome = result.getString(2);
                String senha = result.getString(3);
                Boolean ativo = result.getBoolean(4);

                String out = "Cliente #%d: %s - %s -%d";
                System.out.println(String.format(out, cliente, nome, senha, ativo));
                System.out.println("-----------------------------------------------------------------------");
            }
        } else {
            // all
            String sql = "SELECT * FROM cliente";

            Statement statement = status.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                this.id = result.getInt(1);
                this.nome = result.getString(2);
                this.senha = result.getString(3);
                this.ativo = result.getBoolean(4);

                String out = "Cliente #%d: %s - %s - %d";
                System.out.println(String.format(out, this.id, this.nome, this.senha, this.ativo));
                System.out.println("-----------------------------------");
            }
        }
    }
}
