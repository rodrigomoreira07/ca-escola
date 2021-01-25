package br.com.mstech.escola;

import br.com.caelum.stella.validation.CPFValidator;

public class CPF {

    private String numero;

    public CPF(String numero) {

        CPFValidator cpfValidator = new CPFValidator(); 
        if (numero == null || !cpfValidator.isEligible(numero)) 
            throw new IllegalArgumentException("CPF inválido");
        
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

}
