package lista1.questao5letraA;

public class SynchronizedMap {

	public static void main(String[] args) throws InterruptedException {

		for (int i = 1; i < 3; i = i * 2 ) {
			for (int j = 1; j < i; j++) {
				new Thread(new TestSynchronizedMap(j)).start();
			}
		}
	}
}
