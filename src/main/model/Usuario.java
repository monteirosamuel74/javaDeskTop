package model;

public class Usuario {
    private String nome;
    private String funcao;
    private String contato;

    // Construtor
    public Usuario(String nome, String funcao, String contato) {
        this.nome = nome;
        this.funcao = funcao;
        this.contato = contato;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return nome + " (" + funcao + ") - " + contato;
    }
}