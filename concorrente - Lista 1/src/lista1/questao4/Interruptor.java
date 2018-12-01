package lista1.questao4;

import java.util.Random;

public class Interruptor implements Runnable{
	
	private Inter inter;
	private Random random = new Random();
	public Interruptor(Inter a) {
		this.inter = a;
	}
	
	@Override
	public void run() {
		try {
			Thread.currentThread();
			Thread.sleep(random.nextInt(10000));
			synchronized (inter) {
				inter.setCond(false);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		
		
		
	}

}
