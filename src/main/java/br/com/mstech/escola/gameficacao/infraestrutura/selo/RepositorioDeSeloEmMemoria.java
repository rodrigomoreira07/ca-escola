package br.com.mstech.escola.gameficacao.infraestrutura.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mstech.escola.shared.dominio.CPF;
import br.com.mstech.escola.gameficacao.dominio.selo.RepositorioDeSelo;
import br.com.mstech.escola.gameficacao.dominio.selo.Selo;

public class RepositorioDeSeloEmMemoria implements RepositorioDeSelo {

    List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionarSelo(Selo selo) {
        selos.add(selo);
    }

    @Override
    public List<Selo> buscarSelosDoAluno(CPF cpf) {
        return selos.stream()
            .filter(s -> s.getCpfDoAluno().equals(cpf))
            .collect(Collectors.toList());
    }
    
}
