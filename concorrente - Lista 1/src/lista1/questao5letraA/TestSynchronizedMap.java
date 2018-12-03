package lista1.questao5letraA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestSynchronizedMap implements Runnable {

	public static Map<Integer, String> synchronizedMapObject;
	public static ArrayList<Integer> valores = new ArrayList<>();
	private int quant;
	
	public TestSynchronizedMap(int quant) {
		this.quant = quant;
	}
	
	@Override
	public void run() {

		long tempoE = 0;
		
		for (int j = 0; j <= 5; j++) {

			long startTime = System.nanoTime();
			synchronizedMapObject = Collections.synchronizedMap(new HashMap<Integer, String>());

			for (int i = 0; i < 10000/quant; i++) {
				synchronizedMapObject.put(i, "a" + i);
				System.out.println(synchronizedMapObject.get(i));
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
