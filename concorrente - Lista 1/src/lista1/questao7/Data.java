package lista1.questao7;

import java.util.LinkedList;
import java.util.Queue;

public class Data {
	 private Queue<String> q;
	 private Queue<String> filtrados;
 	
	 public Data() {
		 this.q = new LinkedList<>();
		 this.filtrados = new LinkedList<>();
	 }
	 
	 public void put(String s) {
		 System.out.println(q);
		 this.q.add(s);
	 }
	 public String take() {
		 return this.q.remove();
	 }
	 
	 public void putFiltrados(String s) {
		 this.filtrados.add(s);
	 }
	 public String takeFiltrados() {
		 return this.filtrados.remove();
	 }
	 
	 
	 public boolean isEmpty() {
		 return this.q.isEmpty();
	 }
	 public boolean isEmptyFiltrados() {
		 return this.filtrados.isEmpty();
	 }
	
	
}
