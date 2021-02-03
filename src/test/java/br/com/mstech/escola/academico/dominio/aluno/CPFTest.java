package br.com.mstech.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.mstech.escola.shared.dominio.CPF;

/**
 * CPFTest
 */
public class CPFTest {

    @Test
    public void naoDeveriaCriarCPFInvalido() {
        assertThrows(IllegalArgumentException.class, 
            () -> new CPF(null));

        assertThrows(IllegalArgumentException.class, 
            () -> new CPF("12345678900"));

        assertThrows(IllegalArgumentException.class, 
            () -> new CPF("cpf invalido"));
    }

    @Test
    public void criarCPFValido() {
        String cpfValido = "123.456.789-00";

        assertEquals(cpfValido, (new CPF(cpfValido)).getNumero());
    }
}