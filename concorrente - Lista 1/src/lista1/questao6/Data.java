package lista1.questao6;

import java.util.ArrayList;

public class Data {

	
	private ArrayList<Integer> data;
	private int tamanho = 10;
	
	public Data () {
		this.data = new ArrayList<>();
	}
	
	
	 public void put(int v) {
        
         this.data.add(v);
     }

     public int take() {
    	// System.out.println(data);
         return this.data.remove(0);
    	 
     }

     public boolean isEmpty() {
    	 //System.out.println(this.data.size() <= tamanho);
         return this.data.size() < tamanho;
     }
     public boolean isFull() {
    	 return this.data.size() == tamanho;
     }
 
	

}
