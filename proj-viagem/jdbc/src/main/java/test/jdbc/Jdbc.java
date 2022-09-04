package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc {
    public static void main(String[] args) {
        String dbURL = "jdbc:mariadb://localhost:3306/java";
        String username = "bot";
        String passwd = "shoppe";
        int opt;

        try {
            Scanner in = new Scanner(System.in);
            Connection conn = DriverManager.getConnection(dbURL, username, passwd);
            System.out.println("gostaria de mexer com:");
            System.out.println("1-contatos");
            System.out.println("2-clientes");
            System.out.println("3-contatos");
            opt = in.nextInt();
            if (opt == 1) {
                // TODO separate crud
                System.out.println("1-novo destino");
                System.out.println("2-ver destinos");
                System.out.println("3-atualizar destino");
                System.out.println("4-deletar destino");
                opt = in.nextInt();
                if (opt == 1) {
                    addDestino addDestino = new addDestino(conn);
                } else if (opt == 2) {
                    readDestino readDestino = new readDestino(conn);
                } else if (opt == 3) {
                    updateDestino updateDestino = new updateDestino(conn);
                } else if (opt == 4) {
                    deleteDestino deleteDestino = new deleteDestino(conn);
                }

            } else if (opt == 2) {
                // TODO client CRUD
                System.out.println("1-novo cliente");
                System.out.println("2-ver clientes");
                System.out.println("3-atualizar cliente");
                System.out.println("4-deletar cliente");
                if (opt == 1) {
                    addCliente C = new addCliente(conn);
                } else if (opt == 2) {
                    readCliente R = new readCliente(conn);
                } else if (opt == 3) {
                    updateCliente U = new updateCliente(conn);
                } else if (opt == 4) {
                    deleteCliente D = new deleteCliente(conn);
                }
            } else if (opt == 3) {
                // TODO contato CRUD
            } else {
                // TODO invalid println
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
