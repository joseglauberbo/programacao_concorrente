package lista1.questao5letraA;


public class ConcurrentHashMap {

	public static void main(String[] args) throws InterruptedException {

		for (int i = 1; i < 3; i = i * 2 ) {
			for (int j = 1; j < i; j++) {
				new Thread(new TestConcurrentHashMap(j)).start();
			}
		}
	}
}
