package lista1.questao6;

import java.util.Random;

public class Canal implements Runnable {
	
	private Random random = new Random();
	
	public Canal() {
		
	}
	
	public int gerador() {
		synchronized (random) {
			System.out.println("este é o numero aleatorio produzido pela t1:" + this.random.nextInt(1000));
			return random.nextInt(1000);
		}
	}
	
	public int verificador(int number) {
		System.out.println("este é o numero aleatorio produzido pela t1:" + this.random.nextInt(1000));
		synchronized (random) {
			if (number % 2 == 0) {
				return number;
			} else {
				return -1;
			}
		}
	}

	@Override
	public void run() {
		System.out.println(verificador(this.gerador()));
	}

}
