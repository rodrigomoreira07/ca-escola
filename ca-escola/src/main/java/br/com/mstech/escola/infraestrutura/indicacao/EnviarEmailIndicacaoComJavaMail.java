package br.com.mstech.escola.infraestrutura.indicacao;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage; 
import javax.mail.PasswordAuthentication; 

import br.com.mstech.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.mstech.escola.dominio.indicacao.EmailIndicacao;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	private final String mailSMTPServer = "smtp.gmail.com";;
    private final String mailSMTPServerPort = "465";
    private final String mailAuthUser = "user";
    private final String mailAuthPassword = "pass";

    private Properties initProperties(EmailIndicacao email) {
        
        Properties props = new Properties();

		props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.host", mailSMTPServer); //server SMTP do GMAIL
		props.put("mail.smtp.auth", "true"); //ativa autenticacao
		props.put("mail.smtp.user", email.getRemetente()); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", mailSMTPServerPort); //porta
		props.put("mail.smtp.socketFactory.port", mailSMTPServerPort); //mesma porta para o socket
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

        return props;
    }
    
    @Override
    public void enviarEmail(EmailIndicacao email) {

        Properties props = initProperties(email);

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                    return new PasswordAuthentication("seuemail@gmail.com",
                    "suasenha123");
            }
        });
		session.setDebug(true); //Habilita o LOG das ações executadas durante o envio do email

		//Objeto que contém a mensagem
		Message msg = new MimeMessage(session);

		try {
			//Setando o destinatário
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getDestinatario()));
			//Setando a origem do email
			msg.setFrom(new InternetAddress(email.getRemetente()));
			//Setando o assunto
			msg.setSubject(email.getAssunto());
			//Setando o conteúdo/corpo do email
			msg.setContent(email.getConteudo(),"text/html");

		} catch (Exception e) {
			System.out.println(">> Erro: Completar Mensagem");
			e.printStackTrace();
		}
		
		//Objeto encarregado de enviar os dados para o email
		Transport tr;
		try {
			tr = session.getTransport("smtp"); 
			tr.connect(mailSMTPServer, mailAuthUser, mailAuthPassword);
			msg.saveChanges(); 
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();
		} catch (Exception e) {
			System.out.println(">> Erro: Envio Mensagem");
			e.printStackTrace();
		}

    }
    
}