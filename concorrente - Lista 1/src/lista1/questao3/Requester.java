package lista1.questao3;

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
		System.out.println(time);
		
    	return httpRequester.getPrimeiro();
    }
    
    public String retorno() {
    		
 
    		if(time < 2000) {
    			return reliableRequest();
    		} else {
    			return "tempo ultrapassado";
    		}	
    }
 
}

