package lista1.questao3;

import java.util.Random;

public class Servidor implements Runnable{
	
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
			Thread.sleep(2100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		HTTP.request(getNome());

	}
}