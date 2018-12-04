package lista1.questao5letraB;

public class SynchronizedList {

	public static void main(String[] args) throws InterruptedException {

		for (int i = 1; i < 24; i = i * 2 ) {
			for (int j = 1; j < i; j++) {
				new Thread(new TestSynchronizedList(j)).start();
			}
		}
	}
}
