package test.java_jsp_crud.model

public class Cliente {

    protected int id;

    public Cliente() {
        super();
    }

    public Cliente(int id, Boolean ativo) {
        this.id = id;
        this.ativo = ativo;
    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente(int id, String senha, Boolean ativo) {
        super();
        this.id = id;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Cliente(String nome, String senha, Boolean ativo) {
        super();
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Cliente(int id, String nome, String senha, Boolean ativo) {
        super();
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    protected String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    protected String data_criado;

    public String getData_criado() {
        return data_criado;
    }

    public void setData_criado(String data_criado) {
        this.data_criado = data_criado;
    }

    protected Boolean ativo;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
