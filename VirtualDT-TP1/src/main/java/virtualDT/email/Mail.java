package virtualDT.email;

import virtualDT.exception.EnviarMailException;

public class Mail implements EnviadorDeMails{
	private String body;
	private String subject;
	private String to;
	private String from;
	
	public Mail(String to, String from, String subject, String body) {
		this.body 		= body;
		this.subject	= subject;
		this.to			= to;
		this.from 		= from;
	}

	public void enviarMail(Mail m) throws EnviarMailException {
		// Otro grupo genera el codigo de envio de email, segun el enunciado.
	}
    
}
