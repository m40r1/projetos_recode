package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class updateCliente extends Cliente {
    private final Connection status;


    public updateCliente(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    public void Create(Scanner in, Boolean set_nome, Boolean set_senha, Boolean set_ativo,final int id) throws SQLException {

        if (set_nome == true) {
            String sql = "UPDATE cliente set nome = ? where id = ?";
            PreparedStatement statement = status.prepareStatement(sql);

            System.out.println("novo nome:");
            super.nome = in.nextLine();

            statement.setString(1, super.nome);
            statement.setInt(2,id);

            int rowsInserted = statement.executeUpdate();

            // TODO
            // integras os 3 codigos sql
            // emm um unico update
            // performance um pouco melhor?????
            if (rowsInserted > 0) {
                System.out.println("nome alterado");
            }
        }

        if (set_senha == true) {
            String sql = "UPDATE cliente set senha = ? where id = ?";
            PreparedStatement statement = status.prepareStatement(sql1);

            System.out.println("nova senha:");
            super.senha = in.nextLine();

            statement.setString(2, sql);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("senha alterada");
            }
        }

        if (set_ativo == true) {
            String sql = "UPDATE cliente set ativo = ? where id = ?";
            PreparedStatement statement = status.prepareStatement(sql);

            System.out.println("ativar = 1 ,desativar = 0");
            super.ativo = in.nextBoolean();

            statement.setBoolean(3, super.ativo);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("estado alterado");
            }
        }

    }

}
