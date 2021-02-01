package br.com.mstech.escola.dominio.aluno;

import java.time.LocalDateTime;

import br.com.mstech.escola.dominio.Evento;

public class AlunoMatriculado implements Evento {

    private final CPF cpfDoAluno;
    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    @Override
    public LocalDateTime momento() {
        return momento;
    }
    
}
