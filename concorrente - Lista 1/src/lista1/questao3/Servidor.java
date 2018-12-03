package lista1.questao3;

import java.util.Random;

public class Servidor implements Runnable{
	
	private String nome;
	private HTTPRequest HTTP;
	
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
		
		HTTP.request(getNome());

	}
}