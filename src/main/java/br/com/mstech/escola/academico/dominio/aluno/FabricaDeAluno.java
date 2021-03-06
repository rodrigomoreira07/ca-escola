package br.com.mstech.escola.academico.dominio.aluno;

import br.com.mstech.escola.shared.dominio.CPF;

public class FabricaDeAluno {
    
    private Aluno aluno;

    public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
        aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero) {
        aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar() {
        return aluno;
    }
}