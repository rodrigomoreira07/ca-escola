package br.com.mstech.escola.dominio.aluno;

import br.com.caelum.stella.validation.CPFValidator;

public class CPF {

    private String numero;

    public CPF(String numero) {

        CPFValidator cpfValidator = new CPFValidator(true); 
        if (numero == null || !cpfValidator.isEligible(numero)) 
            throw new IllegalArgumentException("CPF inválido");
        
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return numero;
    }

    public boolean equals(CPF outroCpf) {
        return numero.equals(outroCpf.getNumero());
    }
}
