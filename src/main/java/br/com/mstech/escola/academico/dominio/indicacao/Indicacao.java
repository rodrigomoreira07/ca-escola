package br.com.mstech.escola.academico.dominio.indicacao;

import br.com.mstech.escola.academico.dominio.aluno.Aluno;

public class Indicacao {
    
    private Aluno indicado;

    private Aluno indicante;

    public Indicacao(Aluno indicado, Aluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
    }

    public String getNomeIndicado() {
        return indicado.getNome();
    }

    public String getNomeIndicante() {
        return indicante.getNome();
    }

    public String getEmailIndicado() {
        return indicado.getEmail();
    }

}