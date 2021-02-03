package br.com.mstech.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class EmailTest {
    
    @Test
    public void naoDeveriaCriarEmailsComEnderecoInvalido() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Email(null));

        assertThrows(IllegalArgumentException.class, 
            () -> new Email(""));

        assertThrows(IllegalArgumentException.class, 
            () -> new Email("emailinvalido@com"));
    }

    @Test
    public void criarEmailValido() {
        String endereco = "rodrigomoreira07@gmail.com";

        assertEquals(endereco, 
            (new Email(endereco)).getEndereco());
    }
}