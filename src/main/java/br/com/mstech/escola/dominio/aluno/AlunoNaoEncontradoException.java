package br.com.mstech.escola.dominio.aluno;

public class AlunoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public AlunoNaoEncontradoException(CPF cpf) {
        super("Aluno nao encontrato com CPF: " + cpf.getNumero());
    }

}