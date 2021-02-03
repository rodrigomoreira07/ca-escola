package br.com.mstech;

import br.com.mstech.escola.academico.aplicacao.aluno.MatriculadorDeAluno;
import br.com.mstech.escola.academico.aplicacao.aluno.MatriculadorDeAlunoDto;
import br.com.mstech.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.mstech.escola.academico.dominio.aluno.RepositorioDeAluno;
import br.com.mstech.escola.academico.infraestrutura.aluno.RepositorioDeAlunoEmMemoria;
import br.com.mstech.escola.gameficacao.aplicacao.GeradorDeSeloNovato;
import br.com.mstech.escola.gameficacao.dominio.selo.RepositorioDeSelo;
import br.com.mstech.escola.gameficacao.infraestrutura.selo.RepositorioDeSeloEmMemoria;
import br.com.mstech.escola.shared.dominio.evento.PublicadorDeEventos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Matricula de Aluno!");

        System.out.print("Informe o nome: ");
        String nome = System.console().readLine();

        System.out.print("Informe o CPF: ");
        String cpf = System.console().readLine();

        System.out.print("Informe o E-mail: ");
        String email = System.console().readLine();
        
		MatriculadorDeAlunoDto dto = new MatriculadorDeAlunoDto(nome, cpf, email);

        RepositorioDeAluno repositorioDeAluno = new RepositorioDeAlunoEmMemoria();
        RepositorioDeSelo repositorioDeSelo = new RepositorioDeSeloEmMemoria();

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        publicador.adicionar(new GeradorDeSeloNovato(repositorioDeSelo));

        MatriculadorDeAluno matriculador = new MatriculadorDeAluno(repositorioDeAluno, publicador);
        matriculador.executar(dto);

        System.out.println("Aluno matriculado");
    }
}
