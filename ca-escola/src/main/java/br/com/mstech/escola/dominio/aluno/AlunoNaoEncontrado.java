package br.com.mstech.escola.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno nao encontrato com CPF: " + cpf.getNumero());
    }

}