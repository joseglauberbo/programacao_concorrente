package lista1.questao5letraB;


public class CopyOnWriteArrayList {

	public static void main(String[] args) throws InterruptedException {

		for (int i = 1; i < 3; i = i * 2 ) {
			for (int j = 1; j < i; j++) {
				new Thread(new TestCopyOnWriteArrayList(j)).start();
			}
		}
	}
}
