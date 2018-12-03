package lista1.questao1;

import java.util.Random;

public class Main {
	private static int cont = 0;
	public static void main(String args[]) throws InterruptedException {
		Canal canal = new Canal(10);
	    // Create thread t1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public synchronized void run() {
				while(true) {
				canal.putMessage("estou entrando t1 " + cont);
				cont++;
				try {
					Thread.currentThread();
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		});

		// Create thread t2
		Thread t2 = new Thread(new Runnable() {
			@Override
			public synchronized void run() {
				while(true) {
		
					
				canal.takeMessage();
				try {
					Thread.currentThread();
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}