package lista1.questao6;


public class Main {

	public static void main(String args[]) throws InterruptedException {
		  Data data = new Data();
	        Gerador producer = new Gerador(data);
	        Verificador consumer = new Verificador(data);
	       
	        Thread t0 = new Thread(producer,"Gerador-thread");
	        Thread t1 = new Thread(consumer,"Verificador-thread");

	     
	        t0.start();
	        t1.start();

	        t0.join();;
	        t1.join();
	
		
		
	
	}
}
