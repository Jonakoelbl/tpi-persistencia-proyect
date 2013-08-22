package grupo3;

import grupo3.exception.*;

public interface EnviadorDeMails {
   public void enviarMail(Mail m) throws EnviarMailException;
	
}
