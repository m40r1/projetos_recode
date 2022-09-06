package test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Cliente {

    private final Connection status;

    public Cliente(Connection conn) throws SQLException {
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

    public String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String data_criado;

    public String getData_criado() {
        return data_criado;
    }

    public void setData_criado(String data_criado) {
        this.data_criado = data_criado;
    }

    public Boolean ativo;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
