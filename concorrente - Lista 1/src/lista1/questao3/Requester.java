package lista1.questao3;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.*;

public class Requester {

	private HTTPRequest httpRequester = new HTTPRequest();
	private long time = 0;
	
	public Requester () {
		
	}
    
    public String reliableRequest() {
    	
    	long start = System.currentTimeMillis();
    	
    	new Thread(new Servidor("mirror1.com", httpRequester)).start();
		new Thread(new Servidor("mirror2.br", httpRequester)).start();
		new Thread(new Servidor("mirror3.edu", httpRequester)).start();
		
		
		long elapsed = System.currentTimeMillis() - start;
		
		time = elapsed;
    	return httpRequester.getPrimeiro();
    }
    
    public String retorno() {
    	
    	try {
			if(time < 2000) {
				System.out.println(reliableRequest());
			}
		} catch (Exception e) {
			return "sei la";
		}
    	
     return null;
    }
 
}

