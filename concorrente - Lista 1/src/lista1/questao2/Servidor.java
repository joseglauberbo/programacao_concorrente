package lista1.questao2;

import java.util.Random;

public class Servidor implements Runnable {

	private String nome;
	private HTTPRequest HTTP;
	private Random random = new Random();

	public Servidor(String nome, HTTPRequest httpRequest) {

		this.nome = nome;
		this.HTTP = httpRequest;
	}

	public String getNome() {
		return this.nome;

	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	@Override
	public void run() {
		try {
			Thread.currentThread();
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (this.HTTP) {
			if (this.HTTP.getPrimeiro() != null) {
				Thread.currentThread().interrupt();
			} else {
				System.out.print("servidor: ");
				System.out.println(this.HTTP.request(getNome()));
			}
		}

	}
}