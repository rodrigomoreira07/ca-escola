package br.com.mstech.escola.gameficacao.aplicacao;

import br.com.mstech.escola.gameficacao.dominio.selo.RepositorioDeSelo;
import br.com.mstech.escola.gameficacao.dominio.selo.Selo;
import br.com.mstech.escola.shared.dominio.CPF;
import br.com.mstech.escola.shared.dominio.evento.Evento;
import br.com.mstech.escola.shared.dominio.evento.Ouvinte;
import br.com.mstech.escola.shared.dominio.evento.TipoDeEvento;

public class GeradorDeSeloNovato extends Ouvinte {

    private final RepositorioDeSelo repositorioDeSelo;

    public GeradorDeSeloNovato(RepositorioDeSelo repositorioDeSelo) {
        this.repositorioDeSelo = repositorioDeSelo;
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    protected void reagirAo(Evento evento) {
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        Selo novato = new Selo(cpfDoAluno, "Novato");
        repositorioDeSelo.adicionarSelo(novato);
    }
    
}
