package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc {
    public static void main(String[] args) {
        // Conexao com o banco
        String dbURL = "jdbc:mariadb://localhost:3306/java";
        String username = "bot";
        String passwd = "shoppe";
        int opt = 999;

        try {
            // cli loop
            while (opt != 0) {
                Scanner in = new Scanner(System.in);
                Connection conn = DriverManager.getConnection(dbURL, username, passwd);
                System.out.println("gostaria de mexer com:");
                System.out.println("1-destinos");
                System.out.println("2-clientes");
                System.out.println("3-contatos");
                System.out.println("0-sair");
                opt = in.nextInt();
                switch (opt) {
                case 1 -> {
                    System.out.println("1-novo destino");
                    System.out.println("2-ver destinos");
                    System.out.println("3-atualizar destino");
                    System.out.println("4-deletar destino");
                    opt = in.nextInt();
                    switch (opt) {
                    case 1 -> {
                        addDestino C = new addDestino(conn);
                        C.Create(in);
                    }
                    case 2 -> {
                        readDestino R = new readDestino(conn);
                        R.Read();
                    }
                    case 3 -> {
                        updateDestino U = new updateDestino(conn);
                        U.Update(in);
                    }
                    case 4 -> {
                        deleteDestino D = new deleteDestino(conn);
                        D.Delete(in);
                    }
                    default -> {
                        System.out.println("insira uma opcao valida");
                    }
                    }
                }
                case 2 -> {
                    System.out.println("1-novo cliente");
                    System.out.println("2-ver clientes");
                    System.out.println("3-atualizar cliente");
                    System.out.println("4-deletar cliente");
                    opt = in.nextInt();

                    switch (opt) {

                    case 1 -> {
                        addCliente C = new addCliente(conn);
                        C.Create(in);
                    }

                    case 2 -> {
                        readCliente R = new readCliente(conn);
                        R.Read();
                    }

                    case 3 -> {
                        updateCliente U = new updateCliente(conn);
                        Boolean nome;
                        Boolean senha;
                        Boolean ativo;
                        System.out.println("1-mudar nome");
                        System.out.println("2-mudar senha");
                        System.out.println("3-mudar ativo");
                        opt = in.nextInt();

                        switch (opt) {

                        case 1 -> {
                            nome = true;
                            senha = false;
                            ativo = false;
                            U.Update(in, nome, senha, ativo);
                        }

                        case 2 -> {
                            senha = true;
                            nome = false;
                            ativo = false;
                            U.Update(in, nome, senha, ativo);
                        }

                        case 3 -> {
                            ativo = true;
                            nome = false;
                            senha = false;
                            U.Update(in, nome, senha, ativo);
                        }

                        default -> {
                            System.out.println("insira uma opcao valida");
                        }
                        }
                    }

                    case 4 -> {
                        deleteCliente D = new deleteCliente(conn);
                        D.Delete(in);
                    }

                    default -> {
                        System.out.println("insira uma opcao valida");
                    }
                    }
                }

                case 3 -> {
                    System.out.println("1-novo contato");
                    System.out.println("2-ver contato");
                    System.out.println("3-atualizar contato");
                    System.out.println("4-deletar contato");
                    opt = in.nextInt();

                    switch (opt) {
                    case 1 -> {
                        addContato C = new addContato(conn);
                        C.Create(in);
                    }

                    case 2 -> {
                        readContato R = new readContato(conn);
                        R.Read();
                    }

                    case 3 -> {
                        updateContato U = new updateContato(conn);
                        Boolean nome;
                        Boolean email;
                        System.out.println("1-mudar nome");
                        System.out.println("2-mudar email");
                        opt = in.nextInt();

                        if (opt == 1) {
                            nome = true;
                            email = false;
                            U.Update(in, nome, email);
                        } else if (opt == 2) {
                            nome = false;
                            email = true;
                            U.Update(in, nome, email);
                        }
                    }

                    case 4 -> {
                        deleteContato D = new deleteContato(conn);
                        D.Delete(in);
                    }

                    default -> {
                        System.out.println("insira uma opcao valida");
                    }
                    }
                }

                default -> System.out.println("favor escolher uma das opcoes validas");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
