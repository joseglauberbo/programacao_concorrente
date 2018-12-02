package lista1.questao7;

public class VerificadorString implements Runnable {

	
	
	
	
	public boolean verificaString(String string) {
		for (int i = 0; i < string.length(); i++) {
	          if (Character.isDigit(string.charAt(i))==true)
	          {
	              System.out.println("Possui numeros");
	              return false;
	          }
	        }
		
		
		return true;
	}
	
	
	@Override
	public void run() {
		
		
	}

}
