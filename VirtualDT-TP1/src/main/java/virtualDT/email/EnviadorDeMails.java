package virtualDT.email;

import virtualDT.exception.*;

public interface EnviadorDeMails {
   public void enviarMail(Mail m) throws EnviarMailException;
	
}
