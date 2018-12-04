package lista1.questao5letraB;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList implements Runnable {
	
	public static CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
	public static ArrayList<Integer> valores = new ArrayList<>();
	private int quant;
	
	public TestCopyOnWriteArrayList(int quant) {
		this.quant = quant;
	}
	
	@Override
	public void run() {
		long tempoE = 0;
		
		for (int j = 0; j <= 5; j++) {

			long startTime = System.nanoTime();
			copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();

			for (int i = 0; i < 10000/quant; i++) {
				copyOnWriteArrayList.add(i);
				System.out.println(copyOnWriteArrayList.get(i));
			}
			
			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			tempoE += totalTime;
			System.out.println(totalTime);
		
			valores.add((int) (tempoE/5));
			System.out.println(valores);
		}
		
		System.out.println("Media: " + (tempoE/5));
	}
}
