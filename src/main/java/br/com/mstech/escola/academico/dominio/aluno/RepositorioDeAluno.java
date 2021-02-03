package br.com.mstech.escola.academico.dominio.aluno;

import java.util.List;

import br.com.mstech.escola.shared.dominio.CPF;

public interface RepositorioDeAluno {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();

}
