package br.com.mstech.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * AlunoTest
 */
public class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void beforeEach() {
        FabricaDeAluno fabrica = new FabricaDeAluno();
        aluno = fabrica.comNomeCPFEmail("Nome", "123.456.789-00", "email@dominio.com")
            .criar();
    }

    @Test
    public void deveriaPermitir1Telefone() {
        aluno.adicionarTelefone("15", "12345678");
        assertEquals(1, aluno.getTelefones().size());
    }

    @Test
    public void deveriaPermitir2Telefone() {
        aluno.adicionarTelefone("15", "12345678");
        aluno.adicionarTelefone("15", "12345678");
        assertEquals(2, aluno.getTelefones().size());
    }

    @Test
    public void naoDeveriaPermitir3Telefone() {
        assertThrows(QuantidadeMaximaTelefoneException.class, () -> {
            aluno.adicionarTelefone("15", "12345678");
            aluno.adicionarTelefone("15", "12345678");
            aluno.adicionarTelefone("15", "12345678");
        });
    }
}