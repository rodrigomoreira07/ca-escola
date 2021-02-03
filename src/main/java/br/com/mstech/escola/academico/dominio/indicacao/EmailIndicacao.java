package br.com.mstech.escola.academico.dominio.indicacao;

import br.com.mstech.escola.academico.dominio.aluno.Email;

public class EmailIndicacao {
    
    private final Email remetente = new Email("naoresponda@mstech.com.br");
    private final String assunto = "MS Tech - Você foi indicado";

    private Indicacao indicacao;

    public EmailIndicacao(Indicacao indicacao) {
        this.indicacao = indicacao;
    }

    public String getRemetente() {
        return remetente.getEndereco();
    }

    public String getDestinatario() {
        return indicacao.getEmailIndicado();
    }

    public String getAssunto() {
        return assunto;
    }

    public String getConteudo() {
        String conteudo = "<h1>Boas vindas " + indicacao.getNomeIndicado() + "!!</h1>"
                        + "<p>Você foi indicado por " + indicacao.getNomeIndicante() + ".</p>";

        return conteudo;
    }
}