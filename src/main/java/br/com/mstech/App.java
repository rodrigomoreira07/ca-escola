package br.com.mstech;

import br.com.mstech.escola.aplicacao.aluno.MatriculadorDeAluno;
import br.com.mstech.escola.aplicacao.aluno.MatriculadorDeAlunoDto;
import br.com.mstech.escola.dominio.PublicadorDeEventos;
import br.com.mstech.escola.dominio.aluno.LogDeAlunoMatriculado;
import br.com.mstech.escola.dominio.aluno.RepositorioDeAluno;
import br.com.mstech.escola.infraestrutura.aluno.RepositorioDeAlunoEmMemoria;

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

        RepositorioDeAluno repositorio = new RepositorioDeAlunoEmMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());

        MatriculadorDeAluno matriculador = new MatriculadorDeAluno(repositorio, publicador);
        matriculador.executar(dto);

        System.out.println("Aluno matriculado");
    }
}
