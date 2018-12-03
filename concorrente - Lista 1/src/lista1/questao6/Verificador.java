package lista1.questao6;

public class Verificador implements Runnable{

	
	 private final Data data;

     public Verificador(Data data) {
         this.data  = data;
     }
	
	
     public void run() {

         while (true) {
             synchronized (this.data) {
                 while (this.data.isEmpty()) {
                     try {
                
                         this.data.wait();
                     } catch (InterruptedException e) { }
                 }
                 int taken = this.data.take();
                 
                 if(taken  % 2 == 0) {
                 
                	 System.err.println("valor verificado: " + taken);
                	
             		
                	 
                 }
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
