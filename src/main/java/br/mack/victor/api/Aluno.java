package br.mack.victor.api;

import java.util.Date;

public class Aluno {
    private int tia;
    private String nome;
    private Date auladia;
    private boolean presenca;

    public Aluno() {
    }

    public Aluno(int tia, String nome, Date auladia, boolean presenca) {
        this.tia = tia;
        this.nome = nome;
        this.auladia = auladia;
        this.presenca = presenca;
    }

    public Aluno(String nome, Date auladia) {
        this.nome = nome;
        this.auladia = auladia;
    }

    public long getTia() {
        return tia;
    }

    public String getnome() {
        return nome;
    }

    public Date getAulaDia() {
        return auladia;
    }

    public boolean getPresenca() {
        return presenca;
    }
}
