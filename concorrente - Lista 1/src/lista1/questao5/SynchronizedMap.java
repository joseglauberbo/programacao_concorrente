package lista1.questao5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMap {
	public static Map<Integer, String> synchronizedMapObject = null;
	public static ArrayList<Integer> bichos = new ArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		
		
		for (int i = 1; i < 24; i++ ) {
			for (int j = 1; j < i; j++) {
				contaTempo(j);
				System.out.println(bichos);
			}
			
		}
		
		
	}

	public static void contaTempo(int quanti) {
		long tempoE = 0;
		for (int j = 0; j <= 5; j++) {

			long startTime = System.nanoTime();
			synchronizedMapObject = Collections.synchronizedMap(new HashMap<Integer, String>());

			for (int i = 0; i < 10000/quanti; i++) {
				synchronizedMapObject.put(i, "a" + i);
				System.out.println(synchronizedMapObject.get(i));
			}
			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			tempoE += totalTime;
			System.out.println(totalTime);
		}
		bichos.add((int) (tempoE/5));
		System.out.println("Media: " + (tempoE/5));
	}

}
