package lista1.questao3;

public class HTTPRequest {
	
	private String primeiro = "";
	
	public String request(String serverName) {
		
		if(primeiro == ""){
			this.primeiro = serverName;
		}
		return serverName;
	}

	public String getPrimeiro() {
		return this.primeiro;
	}
	
}