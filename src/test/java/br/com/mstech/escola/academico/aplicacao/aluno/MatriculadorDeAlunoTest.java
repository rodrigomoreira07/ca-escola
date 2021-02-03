package br.com.mstech.escola.academico.aplicacao.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.mstech.escola.academico.dominio.aluno.Aluno;
import br.com.mstech.escola.academico.dominio.aluno.RepositorioDeAluno;
import br.com.mstech.escola.academico.infraestrutura.aluno.RepositorioDeAlunoEmMemoria;
import br.com.mstech.escola.shared.dominio.CPF;
import br.com.mstech.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatriculadorDeAlunoTest {
    
    @Test
    public void deveriaMaricularAluno() {

        RepositorioDeAluno repositorio = new RepositorioDeAlunoEmMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();

        MatriculadorDeAluno matriculadorDeAluno = new MatriculadorDeAluno(repositorio, publicador);

        String nome = "Nome Aluno";
        String cpf = "123.456.789-00";
        String email = "aluno@gmail.com";

        MatriculadorDeAlunoDto dto = new MatriculadorDeAlunoDto(nome, cpf, email);
        matriculadorDeAluno.executar(dto);

        Aluno aluno = repositorio.buscarPorCPF(new CPF(cpf));

        assertEquals(nome, aluno.getNome());
        assertEquals(cpf, aluno.getCpf());
        assertEquals(email, aluno.getEmail());
    }
}