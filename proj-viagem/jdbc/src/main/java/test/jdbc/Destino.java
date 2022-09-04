package test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Destino {
    private final Connection status;

    public Destino(Connection conn) throws SQLException {
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

    public String continente;

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String pais;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int preco;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int desconto;

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public int preco_desconto;

    public int getPreco_desconto() {
        return preco_desconto;
    }

    public void setPreco_desconto(int preco_desconto) {
        this.preco_desconto = preco_desconto;
    }

    public String duracao;

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

}
