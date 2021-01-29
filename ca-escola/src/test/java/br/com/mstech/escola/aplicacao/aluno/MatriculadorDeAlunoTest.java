package br.com.mstech.escola.aplicacao.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.mstech.escola.dominio.aluno.Aluno;
import br.com.mstech.escola.dominio.aluno.CPF;
import br.com.mstech.escola.dominio.aluno.RepositorioDeAluno;
import br.com.mstech.escola.infraestrutura.aluno.RepositorioDeAlunoEmMemoria;

public class MatriculadorDeAlunoTest {
    
    @Test
    public void deveriaMaricularAluno() {

        RepositorioDeAluno repositorio = new RepositorioDeAlunoEmMemoria();

        MatriculadorDeAluno matriculadorDeAluno = new MatriculadorDeAluno(repositorio);

        String nome = "Nome Aluno";
        String cpf = "123.456.789-00";
        String email = "aluno@gmail.com";

        AlunoDto dto = new AlunoDto(nome, cpf, email);
        matriculadorDeAluno.executar(dto);

        Aluno aluno = repositorio.buscarPorCPF(new CPF(cpf));

        assertEquals(nome, aluno.getNome());
        assertEquals(cpf, aluno.getCpf());
        assertEquals(email, aluno.getEmail());
    }
}