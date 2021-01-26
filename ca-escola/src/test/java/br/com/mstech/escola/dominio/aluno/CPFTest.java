package br.com.mstech.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * CPFTest
 */
public class CPFTest {

    @Test
    public void naoDeveriaCriarCPFInvalido() {
        assertThrows(IllegalArgumentException.class, 
            () -> new CPF(null));

        assertThrows(IllegalArgumentException.class, 
            () -> new CPF("32425795855"));

        assertThrows(IllegalArgumentException.class, 
            () -> new CPF("cpf invalido"));
    }

    @Test
    public void criarCPFValido() {
        String cpfValido = "324.257.958-55";

        assertEquals(cpfValido, (new CPF(cpfValido)).getNumero());
    }
}