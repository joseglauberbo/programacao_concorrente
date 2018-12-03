package lista1.questao7;

import java.util.Random;


public class GeradorString implements Runnable {
	private static Random rand = new Random();
	private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
	private Data data;
	public GeradorString(Data data) {
		this.data = data;
	}
	
	
	
	public synchronized String geraString () {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i <5; i++) {
	        int ch = rand.nextInt (letras.length);
	        sb.append (letras [ch]);
	    }
	   
	    return sb.toString();    
	}
	
	
	@Override
	public void run() {
        while (true) {
            synchronized (this.data) {
                while (!this.data.isEmpty()) {
                    try {
                        //the buffer is full. 
                        //wait until something is consumed
                        this.data.wait();
                    } catch (InterruptedException e) { }
                }
                String stringGerada = this.geraString();
                this.data.put(stringGerada);
                try {
        			Thread.currentThread();
        			Thread.sleep(1001);
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		} 
                this.data.notifyAll();
            }
        }
    }
}
