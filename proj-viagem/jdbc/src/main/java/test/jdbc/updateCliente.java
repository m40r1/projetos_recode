package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateCliente extends Cliente {

    private final Connection status;

    // paassar para o Cliente
    public updateCliente(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    // Booleans para tipos de update
    public void Update(Scanner in, Boolean set_nome, Boolean set_senha, Boolean set_ativo) throws SQLException {
        // update nome
        if (set_nome == true) {
            String sql = "UPDATE cliente set nome = ? where id = ?";
            PreparedStatement statement = status.prepareStatement(sql);

            in.nextLine();
            System.out.println("novo nome:");
            super.nome = in.nextLine();
            System.out.println("para a id:");
            this.id = in.nextInt();

            statement.setString(1, super.nome);
            statement.setInt(2, this.id);

            int rowsInserted = statement.executeUpdate();

            // TODO
            // integras os 3 codigos sql
            // emm um unico update
            // performance um pouco melhor?????
            if (rowsInserted > 0) {
                System.out.println("nome alterado");
            }
        }
        // update senha
        if (set_senha == true) {
            String sql = "UPDATE cliente set senha = ? where id = ?";
            PreparedStatement statement = status.prepareStatement(sql);

            in.nextLine();
            System.out.println("nova senha:");
            super.senha = in.nextLine();
            System.out.println("para a id:");
            this.id = in.nextInt();

            statement.setString(1, sql);
            statement.setInt(2, this.id);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("senha alterada");
            }
        }
        // desativar usuario
        if (set_ativo == true) {
            String sql = "UPDATE cliente set ativo = ? where id = ?";
            PreparedStatement statement = status.prepareStatement(sql);

            System.out.println("ativar = true ,desativar = false");
            super.ativo = in.nextBoolean();
            System.out.println("para a id:");
            this.id = in.nextInt();

            statement.setBoolean(1, super.ativo);
            statement.setInt(2, this.id);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("estado alterado");
            }
        }

    }

}
