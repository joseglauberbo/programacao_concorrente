package lista1.questao2;

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