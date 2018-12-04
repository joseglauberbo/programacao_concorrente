package lista1.questao5letraB;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class TestSynchronizedList implements Runnable {

	public static List<String> SynchronizedList = new ArrayList<String>();
	public static ArrayList<Integer> valores = new ArrayList<>();
	private int quant;
	
	public TestSynchronizedList(int quant) {
		this.quant = quant;
	}
	
	@Override
	public void run() {
		long tempoE = 0;
		
		for (int j = 0; j <= 5; j++) {

			long startTime = System.nanoTime();
			SynchronizedList = Collections.synchronizedList(SynchronizedList);

			for (int i = 0; i < 10000/quant; i++) {
				SynchronizedList.add("a");
				System.out.println(SynchronizedList.get(i));
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
