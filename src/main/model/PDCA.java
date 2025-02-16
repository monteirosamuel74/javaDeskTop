package model;

public class PDCA extends Ferramenta {
    private String objetivo;
    private String plano;
    private String execucao;
    private String verificacao;
    private String acao;
    
        public PDCA(String nome) {
            super(nome, "PDCA");
    }

    // Getters e Setters para os campos específicos do PDCA
    public String getObjetivo() {
        return objetivo;
    }

    public String getTipo() {
        return super.getTipo(); // Retorna o tipo da classe base
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getExecucao() {
        return execucao;
    }

    public void setExecucao(String execucao) {
        this.execucao = execucao;
    }

    public String getVerificacao() {
        return verificacao;
    }

    public void setVerificacao(String verificacao) {
        this.verificacao = verificacao;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
}