package test.java_jsp_crud.model;

public class Destino {

    public Destino() {
    }

    public Destino(String nome, String continente, String pais, int preco, int desconto, int preco_desconto,
            String duracao) {

        super();
        this.nome = nome;
        this.continente = continente;
        this.pais = pais;
        this.preco = preco;
        this.desconto = desconto;
        this.preco_desconto = preco_desconto;
        this.duracao = duracao;
    }

    public Destino(int id, int preco, int desconto, String duracao) {
        this.id = id;
        this.preco = preco;
        this.desconto = desconto;
        this.duracao = duracao;
    }

    public Destino(int id, String nome, String continente, String pais, int preco, int desconto, int preco_desconto,
            String duracao) {

        super();
        this.id = id;
        this.nome = nome;
        this.continente = continente;
        this.pais = pais;
        this.preco = preco;
        this.desconto = desconto;
        this.preco_desconto = preco_desconto;
        this.duracao = duracao;
    }

    protected int id;

    protected String nome;

    protected String continente;

    protected String pais;

    protected int preco;

    protected int desconto;

    protected int preco_desconto;

    protected String duracao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public int getPreco_desconto() {
        return preco_desconto;
    }

    public void setPreco_desconto(int preco_desconto) {
        this.preco_desconto = preco_desconto;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
};
