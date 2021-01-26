package br.com.mstech.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void adicionarTelefone(Telefone telefone) {
        telefones.add(telefone);
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        return Collections.unmodifiableList(telefones);
    }
}