package lista1.questao7;

public class Impressor implements Runnable {
	private Data data;
	
	public Impressor(Data data) {
		this.data = data;
	}
	
	
	
	@Override
	public void run() {
		while (true) {
            synchronized (this.data) {
                while (this.data.isEmptyFiltrados()) {
                    try {
                        //the buffer is full. 
                        //wait until something is consumed
                        this.data.wait();
                    } catch (InterruptedException e) { }
                }
                String v = this.data.takeFiltrados();
                System.out.println("String alpha:" + v);
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


