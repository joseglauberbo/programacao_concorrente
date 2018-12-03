package lista1.questao5letraB;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap; 

public class TestConcurrentHashMap implements Runnable {

		public static Map<Integer, String> ConcurrentHashMap;
		public static ArrayList<Integer> valores = new ArrayList<>();
		private int quant;
		
		public TestConcurrentHashMap (int quant) {
			this.quant = quant;
		}
		
		@Override
		public void run() {

			long tempoE = 0;
			
			for (int j = 0; j <= 5; j++) {

				long startTime = System.nanoTime();
				ConcurrentHashMap = new ConcurrentHashMap<Integer, String>();

				for (int i = 0; i < 10000/quant; i++) {
					ConcurrentHashMap.put(i, "a" + i);
					System.out.println(ConcurrentHashMap.get(i));
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
