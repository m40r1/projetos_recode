package test.java_jsp_crud.model;

public class Contato {

    protected int id;

    public Contato() {
        super();
    }

    public Contato(String nome, String email) {
        super();
        this.nome = nome;
        this.email = email;
    }

    public Contato(int id, String nome, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Contato(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    protected String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
