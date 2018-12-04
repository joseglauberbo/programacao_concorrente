package lista1.questao3;

import java.util.Random;

public class Requester {

	private HTTPRequest httpRequester = new HTTPRequest();
	private long time = 0;
	private Random random = new Random();
	
	public long getTime() {
		return time;
	}

	public Requester () {
		
	}
    
	public void createThread() {
		
		new Thread(new Servidor("mirror1.com", httpRequester)).start();
		new Thread(new Servidor("mirror2.br", httpRequester)).start();
		new Thread(new Servidor("mirror3.edu", httpRequester)).start();
	
	}
	
    public String reliableRequest() throws InterruptedException {
    
    	
    	long start = System.currentTimeMillis();
    	
    	this.createThread();
    	
    	try {
			Thread.currentThread();
			Thread.sleep(random.nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
		long elapsed = System.currentTimeMillis() - start;
		
		time = elapsed;
		System.out.println(time);
    	return httpRequester.getPrimeiro();
    }
    
    public String retorno(String result, long time) {
    		
    		if(time < 2000) {
    			return result;
    		} else {
    			return "Erro: tempo ultrapassado";
    		}	
    }
 
}

