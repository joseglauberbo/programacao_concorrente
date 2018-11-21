package lista1.questao2;



public class Main {

	public static void main(String args[]) throws InterruptedException {
		new Thread(new Servidor("mirror1.com")).start();
        new Thread(new Servidor("mirror2.br")).start();
        new Thread(new Servidor("mirror3.edu")).start();

        
        
	}
	public static String reliableRequest() {
		return null;
	}

}
