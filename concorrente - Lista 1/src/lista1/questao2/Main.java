package lista1.questao2;

public class Main {

	public static void main(String args[]) throws InterruptedException {

		Requester req = new Requester();
		try {
			Thread.currentThread();
			Thread.sleep(1001);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(req.reliableRequest());

	}

}