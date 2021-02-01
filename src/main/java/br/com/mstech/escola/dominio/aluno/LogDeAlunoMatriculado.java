package br.com.mstech.escola.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.mstech.escola.dominio.Evento;
import br.com.mstech.escola.dominio.Ouvinte;

public class LogDeAlunoMatriculado extends Ouvinte {

    public void reageAo(AlunoMatriculado evento) {
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println(String.format("Aluno com CPF %s matriculado em %s", evento.getCpfDoAluno(), momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }

    @Override
    protected void reagirAo(Evento evento) {
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println(String.format("Aluno com CPF %s matriculado em %s", 
                ((AlunoMatriculado) evento).getCpfDoAluno(), momentoFormatado));
    }
}
