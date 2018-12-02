package lista1.questao7;

import java.util.Random;


public class GeradorString implements Runnable {
	private static Random rand = new Random();
	private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
	
	public GeradorString() {
		
	}
	
	
	
	public String geraString () {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i <5; i++) {
	        int ch = rand.nextInt (letras.length);
	        sb.append (letras [ch]);
	    }    
	    return sb.toString();    
	}
	
	
	
	
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
