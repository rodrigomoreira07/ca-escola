package br.com.mstech.escola.dominio.indicacao;

import br.com.mstech.escola.dominio.aluno.Aluno;

public class Indicacao {
    
    private Aluno indicado;

    private Aluno indicante;

    public Indicacao(Aluno indicado, Aluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
    }
}