package br.com.mstech.escola.academico.aplicacao.aluno;

import br.com.mstech.escola.academico.dominio.aluno.Aluno;
import br.com.mstech.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.mstech.escola.academico.dominio.aluno.FabricaDeAluno;
import br.com.mstech.escola.academico.dominio.aluno.RepositorioDeAluno;
import br.com.mstech.escola.shared.dominio.evento.PublicadorDeEventos;

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