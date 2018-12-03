package lista1.questao7;

public class VerificadorString implements Runnable {
	private Data data;
	
	public VerificadorString(Data data) {
		this.data = data;
	}
	
	
	
	public  boolean verificaString(String string) {
		for (int i = 0; i < string.length(); i++) {
	          if (Character.isDigit(string.charAt(i))==true)
	          {
	              System.out.println("String filtada possui numeros:" + string);
	              return false;
	          }
	        }
		return true;
	}
	
	
	@Override
	public void run() {
		
		  while (true) {
              synchronized (this.data) {
                  while (this.data.isEmpty()) {
                      try {
                          this.data.wait();
                      } catch (InterruptedException e) { }
                  }
                  String v = this.data.take();
                  if(this.verificaString(v)) {
                	  data.putFiltrados(v);
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


