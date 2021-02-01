package br.com.mstech.escola.aplicacao.aluno;

import br.com.mstech.escola.dominio.PublicadorDeEventos;
import br.com.mstech.escola.dominio.aluno.Aluno;
import br.com.mstech.escola.dominio.aluno.AlunoMatriculado;
import br.com.mstech.escola.dominio.aluno.FabricaDeAluno;
import br.com.mstech.escola.dominio.aluno.RepositorioDeAluno;

public class MatriculadorDeAluno {
    
    private final RepositorioDeAluno repositorioDeAluno;
    private final PublicadorDeEventos publicadorDeEventos;

    public MatriculadorDeAluno(RepositorioDeAluno repositorioDeAluno, PublicadorDeEventos publicadorDeEventos) {
        this.repositorioDeAluno = repositorioDeAluno;
        this.publicadorDeEventos = publicadorDeEventos;
    }

    public void executar(MatriculadorDeAlunoDto dto) {        
        FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
        fabricaDeAluno.comNomeCPFEmail(dto.getNome(), dto.getCpf(), dto.getEmail());
        Aluno aluno = fabricaDeAluno.criar();
        
        repositorioDeAluno.matricular(aluno);

        AlunoMatriculado evento = new AlunoMatriculado(aluno.getCpf());
        publicadorDeEventos.publicar(evento);
    }

}