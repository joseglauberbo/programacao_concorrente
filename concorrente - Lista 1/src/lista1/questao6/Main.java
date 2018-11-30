package lista1.questao6;


public class Main {

	public static void main(String args[]) throws InterruptedException {
		
		Canal canal = new Canal();
      
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public synchronized void run() {
				canal.gerador();
			}
			
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public synchronized void run() {
				canal.verificador(canal.gerador());
			}
		});
	
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
	}
}
