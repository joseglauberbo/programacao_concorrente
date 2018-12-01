package lista1.questao4;

public class HTTPRequest {
	
	private String primeiro = "";
	
	public String request(String serverName) {
		synchronized (this.primeiro) {
			if(primeiro == ""){
				this.primeiro = serverName;
			}
		}
		
		return serverName;
	}

	public String getPrimeiro() {
		return this.primeiro;
	}
	
}