package lista1.questao3;

public class HTTPRequest {

	private String primeiro = null;

	public String request(String serverName) {
		if (primeiro == null) {
			this.primeiro = serverName;
		}

		return serverName;
	}

	public String getPrimeiro() {
		return this.primeiro;
	}

}