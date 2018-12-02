package lista1.questao7;



public class Main {

	
	public static void main(String args[]) {
		GeradorString g = new GeradorString();
		VerificadorString v = new VerificadorString();
		String gerado = g.geraString();
		System.out.println(gerado);
		System.out.println(v.verificaString(gerado));
		
	}
}
