package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.ResultSet;
import java.sql.Statement;

public class readCliente extends Cliente {
    private final Connection status;

    public readCliente(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    public void Read() throws SQLException {

        // TODO conferir se e possivel olhar id especifica
        // problemas com result set e prepared statement

        // System.out.println("para ver todos os perfis digite 0");
        // System.out.println("para um perfil especifico passar sua id");
        // this.id = in.nextInt();
        //
        // if (this.id != 0) {
        // unique user
        // String sql = "SELECT * FROM cliente where id = ?";
        //
        // PreparedStatement statement = status.prepareStatement(sql);
        // statement.setInt(1,this.id);
        // ResultSet result = statement.executeQuery(sql);
        //
        // while (result.next()) {
        // String nome = result.getString(2);
        // String senha = result.getString(3);
        // Boolean ativo = result.getBoolean(4);
        //
        // String out = "Cliente #%d: %s - %s -%d";
        // System.out.println(String.format(out, this.id, nome, senha, ativo));
        // System.out.println("-----------------------------------------------------------------------");
        // }
        // } else {
        // // all
        String sql = "SELECT * FROM cliente";

        Statement statement = status.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            this.id = result.getInt(1);
            this.nome = result.getString(2);
            this.senha = result.getString(3);
            this.ativo = result.getBoolean(4);

            String out = "Cliente #%d: %s - %s - %s";
            System.out.println(String.format(out, this.id, this.nome, this.senha, this.ativo));
            System.out.println("-----------------------------------");
            // }
        }
    }
}
