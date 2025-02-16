package model;

public class CincoW2H extends Ferramenta {
    private String objetivo;
    private String what;
    private String why;
    private String where;
    private String when;
    private String who;
    private String how;
    private String howMuch;
    
        public CincoW2H(String nome) {
            super(nome,"5W2H");
    }

    // Getters e Setters para os campos específicos do 5W2H
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getTipo() {
        return super.getTipo(); // Retorna o tipo da classe base
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public String getHowMuch() {
        return howMuch;
    }

    public void setHowMuch(String howMuch) {
        this.howMuch = howMuch;
    }
}