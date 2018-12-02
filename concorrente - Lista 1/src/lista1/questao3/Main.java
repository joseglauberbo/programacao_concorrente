package lista1.questao3;



public class Main {

	public static void main(String args[]) throws InterruptedException {
		
		Requester req = new Requester(); 
		
		String result = req.reliableRequest();
		//req.retorno(result, req.getTime());
		System.out.println(req.retorno(result, req.getTime()));
	}
	
}