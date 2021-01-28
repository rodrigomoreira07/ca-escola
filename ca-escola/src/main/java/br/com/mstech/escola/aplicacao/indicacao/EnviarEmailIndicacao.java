package br.com.mstech.escola.aplicacao.indicacao;

import br.com.mstech.escola.dominio.indicacao.EmailIndicacao;

public interface EnviarEmailIndicacao {
    
    void enviarEmail(EmailIndicacao email);

}