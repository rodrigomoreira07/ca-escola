package br.com.mstech.escola.dominio.aluno;

import java.util.List;

public interface RepositorioDeAluno {
    
    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();

}