package concorrentes;

public class Main {


	public static void main(String args[]) throws InterruptedException {
		Canal canal = new Canal(2);

		// Create thread t1 
		Thread t1 = new Thread(new Runnable() { 
			@Override
			public synchronized void run() 
			{ 
				//canal.putMessage("deus");
				canal.putMessage("estou entrando t1 1");


			} 
		});

		// Create thread t2 
		Thread t2 = new Thread(new Runnable() { 
			@Override
			public synchronized void run() 
			{ 
				canal.putMessage("estou entrando t2 1");
				//canal.putMessage("estou entrando t2 2");
				canal.takeMessage();
				canal.takeMessage();
			} 
		}); 


		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}
