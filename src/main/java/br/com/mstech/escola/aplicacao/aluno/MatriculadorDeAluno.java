package br.com.mstech.escola.aplicacao.aluno;

import br.com.mstech.escola.dominio.aluno.Aluno;
import br.com.mstech.escola.dominio.aluno.FabricaDeAluno;
import br.com.mstech.escola.dominio.aluno.RepositorioDeAluno;

public class MatriculadorDeAluno {
    
    private final RepositorioDeAluno repositorioDeAluno;

    public MatriculadorDeAluno(RepositorioDeAluno repositorioDeAluno) {
        this.repositorioDeAluno = repositorioDeAluno;
    }

    public void executar(AlunoDto dto) {        
        FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
        fabricaDeAluno.comNomeCPFEmail(dto.getNome(), dto.getCpf(), dto.getEmail());
        Aluno aluno = fabricaDeAluno.criar();
        
        repositorioDeAluno.matricular(aluno);
    }

}