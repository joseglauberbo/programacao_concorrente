package lista1.questao3;



public class Main {

	public static void main(String args[]) throws InterruptedException {
		
		Requester req = new Requester();
		
		try {
			Thread.currentThread();
			Thread.sleep(1001);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		String result = req.reliableRequest();
		System.out.println(req.retorno(result, req.getTime()));
	}
	
}