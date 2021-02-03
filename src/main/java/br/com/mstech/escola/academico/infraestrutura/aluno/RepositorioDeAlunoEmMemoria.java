package br.com.mstech.escola.academico.infraestrutura.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.mstech.escola.academico.dominio.aluno.Aluno;
import br.com.mstech.escola.academico.dominio.aluno.AlunoNaoEncontradoException;
import br.com.mstech.escola.academico.dominio.aluno.RepositorioDeAluno;
import br.com.mstech.escola.shared.dominio.CPF;

public class RepositorioDeAlunoEmMemoria implements RepositorioDeAluno {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return matriculados.stream()
            .filter(a -> a.getCpf().equals(cpf))
            .findFirst()
            .orElseThrow(() -> new AlunoNaoEncontradoException(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return matriculados;
    }
    
}