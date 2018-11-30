package lista1.questao6;

import java.util.Random;

public class Gerador implements Runnable {
	
	private Random random = new Random();
	
	private Data data;

    public Gerador(Data data) {
        this.data = data;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (this.data) {
               
            	 while (this.data.isFull()) {
                     try {
                    	 System.out.println("esta cheio");
                         //the buffer is empty
                         //wait until something be produced
                         this.data.wait();
                     } catch (InterruptedException e) { }
                 }
            	
            	
            	
                int produced = this.random.nextInt(1000);
                this.data.put(produced);
                System.err.println("value produced: " + produced);
              
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



