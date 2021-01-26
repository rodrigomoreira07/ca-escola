import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.mstech.escola.Telefone;

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
            () -> new Telefone("15", "numeroInvalido"));
    }
}