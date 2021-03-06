package br.com.mstech.escola.academico.dominio.aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mstech.escola.shared.dominio.CPF;

/**
 * Aluno
 */
public class Aluno {

    private CPF cpf;

    private String nome;

    private Email email;

    private List<Telefone> telefones = new ArrayList<Telefone>();

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        if (telefones.size() == 2)
            throw new QuantidadeMaximaTelefoneException();

        telefones.add(new Telefone(ddd,  numero));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return Collections.unmodifiableList(telefones);
    }
}