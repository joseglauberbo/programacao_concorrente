package lista1.questao2;

public class Requester {

	private HTTPRequest httpRequester = new HTTPRequest();
	
	public Requester () {
		new Thread(new Servidor("mirror1.com", httpRequester)).start();
		new Thread(new Servidor("mirror2.br", httpRequester)).start();
		new Thread(new Servidor("mirror3.edu", httpRequester)).start();
	}
    
    public String reliableRequest() {
    	
    	return httpRequester.getPrimeiro();
    }
 
}

