package br.com.mstech.escola.academico.aplicacao.indicacao;

import br.com.mstech.escola.academico.dominio.indicacao.EmailIndicacao;

public interface EnviarEmailIndicacao {
    
    void enviarEmail(EmailIndicacao email);

}