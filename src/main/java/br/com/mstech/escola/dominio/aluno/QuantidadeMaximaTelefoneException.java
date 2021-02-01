package br.com.mstech.escola.dominio.aluno;

/**
 * QuantidadeMaximaTelefoneException
 */
public class QuantidadeMaximaTelefoneException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QuantidadeMaximaTelefoneException() {
        super("Quantidade máxima de telefone de aluno não pode ser maior que dois.");
    }
    
}