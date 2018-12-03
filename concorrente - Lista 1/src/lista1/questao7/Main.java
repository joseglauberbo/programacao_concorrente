package lista1.questao7;



public class Main {
	private static Data data = new Data();
	
	public static void main(String args[]) throws InterruptedException {
		GeradorString g = new GeradorString(data);
		VerificadorString v = new VerificadorString(data);
		Impressor i = new Impressor(data);
		
        Thread t0 = new Thread(g,"gerador-thread");
        Thread t1 = new Thread(v,"verificador-thread");
        Thread t2 = new Thread(i,"Impressor-thread");
        t0.start();
        t1.start();
        t2.start();

        t0.join();
        t1.join();
        t2.join();
        

		
	}
}
