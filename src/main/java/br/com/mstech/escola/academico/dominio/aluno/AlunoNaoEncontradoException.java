package br.com.mstech.escola.academico.dominio.aluno;

import br.com.mstech.escola.shared.dominio.CPF;

public class AlunoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public AlunoNaoEncontradoException(CPF cpf) {
        super("Aluno nao encontrato com CPF: " + cpf.getNumero());
    }

}