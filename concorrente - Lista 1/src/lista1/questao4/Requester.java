package lista1.questao4;

public class Requester {

	private HTTPRequest httpRequester;
	private Inter inter = new Inter();
	
	
	
	public Requester () {
		
		
		
	}
    public void criacao() {
    	httpRequester = new HTTPRequest();
    	new Thread(new Servidor("mirror1.com", httpRequester)).start();
		new Thread(new Servidor("mirror2.br", httpRequester)).start();
		new Thread(new Servidor("mirror3.edu", httpRequester)).start();
		new Thread(new Interruptor(inter)).start();
		
    }
   
	public void realizaChamada() {
		while(this.inter.getCond()) {
			System.out.println(this.reliableRequest());
		} 
		System.out.println("Condição de parada atingida.");
		
	}
	
	public String reliableRequest() {
		this.criacao();
		try {
			Thread.currentThread();
			Thread.sleep(1001);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
    	return httpRequester.getPrimeiro();
    }
 
}

