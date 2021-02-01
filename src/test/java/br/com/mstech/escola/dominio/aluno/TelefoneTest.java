package br.com.mstech.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * TelefoneTest
 */
public class TelefoneTest {

    @Test
    public void naoDeveriaCriarTelefoneInvalido() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Telefone(null, null));

        assertThrows(IllegalArgumentException.class, 
            () -> new Telefone("123", "12345668"));

        assertThrows(IllegalArgumentException.class, 
            () -> new Telefone("15", "123"));

        assertThrows(IllegalArgumentException.class, 
            () -> new Telefone("15", "1234567890"));

        assertThrows(IllegalArgumentException.class, 
            () -> new Telefone("15", "numeroInvalido"));
    }

    @Test
    public void criarTelefonesValidos() {
        assertEquals("(15) 12345678", (new Telefone("15", "12345678")).toString());

        assertEquals("(15) 123456789", (new Telefone("15", "123456789")).toString());
    }
}