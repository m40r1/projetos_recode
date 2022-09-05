package test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Contato {
    private final Connection status;

    public Contato(Connection conn) throws SQLException {
        this.status = conn;
    }

    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
