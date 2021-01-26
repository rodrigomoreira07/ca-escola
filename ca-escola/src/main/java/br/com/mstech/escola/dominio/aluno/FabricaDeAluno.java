package br.com.mstech.escola.dominio.aluno;

public class FabricaDeAluno {
    
    private Aluno aluno;

    public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
        aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero) {
        aluno.adicionarTelefone(new Telefone(ddd, numero));
        return this;
    }

    public Aluno criar() {
        return aluno;
    }
}