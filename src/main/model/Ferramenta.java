package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Ferramenta {
    private String nome;
    private List<Usuario> participantes;

    public Ferramenta(String nome) {
        this.nome = nome;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void adicionarParticipante(Usuario usuario) {
        participantes.add(usuario);
    }

    public void removerParticipante(Usuario usuario) {
        participantes.remove(usuario);
    }

    @Override
    public String toString() {
        return nome + " - Participantes: " + participantes.size();
    }
}