package lista1.questao2;

public class Servidor implements Runnable{
	private String nome;
	private HTTPRequest HTTP;
	
	public Servidor(String nome) {
		this.nome = nome;
		this.HTTP = new HTTPRequest();
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
