package br.com.mstech.escola.aplicacao.aluno;

public class MatriculadorDeAlunoDto {

    private String nome;

    private String cpf;

    private String email;

    public MatriculadorDeAlunoDto(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
