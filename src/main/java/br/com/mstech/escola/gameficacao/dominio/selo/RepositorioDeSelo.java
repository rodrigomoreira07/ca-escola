package br.com.mstech.escola.gameficacao.dominio.selo;

import java.util.List;

import br.com.mstech.escola.shared.dominio.CPF;

public interface RepositorioDeSelo {
    
    void adicionarSelo(Selo selo);

    List<Selo> buscarSelosDoAluno(CPF cpf);

}
