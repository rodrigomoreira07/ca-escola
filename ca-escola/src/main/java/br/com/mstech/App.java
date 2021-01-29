package br.com.mstech;

import br.com.mstech.escola.aplicacao.aluno.AlunoDto;
import br.com.mstech.escola.aplicacao.aluno.MatriculadorDeAluno;
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
        
		AlunoDto dto = new AlunoDto(nome, cpf, email);

        MatriculadorDeAluno matriculador = new MatriculadorDeAluno(new RepositorioDeAlunoEmMemoria());
        matriculador.executar(dto);

        System.out.println("Aluno matriculado");
    }
}
