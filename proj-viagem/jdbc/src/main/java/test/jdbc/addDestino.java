package test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class addDestino extends Destino {

    private final Connection status;

    public addDestino(Connection conn) throws SQLException {
        super(conn);
        this.status = conn;
    }

    public void Create(Scanner in) throws SQLException {

        String sql = "INSERT INTO destino (nome,continente,pais,preco,desconto,preco_desconto,duracao) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement statement = status.prepareStatement(sql);

        in.nextLine();
        System.out.println("Nome do destino:");
        super.nome = in.nextLine();
        System.out.println("continente de destino:");
        super.continente = in.nextLine();
        System.out.println("pais de destinos");
        super.pais = in.nextLine();
        System.out.println("preco do pacote");
        super.preco = in.nextInt();
        System.out.println("Porcentagem do desconto");
        super.desconto = in.nextInt();
        this.preco_desconto = ((super.preco/100)*desconto)-super.preco;
        System.out.println("duracao do pacote");
        super.duracao = in.nextLine();


        statement.setString(1, this.nome);
        statement.setString(2, this.continente);
        statement.setString(3, this.pais);
        statement.setInt(4, this.preco);
        statement.setInt(5, this.desconto);
        statement.setInt(6, this.preco_desconto);
        statement.setString(7, duracao);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Novo destino");
        }

    }
}
