package lista1.questao1;

import java.util.ArrayList;

public class Canal implements Channel, Runnable{

	private int tamanho;
	private ArrayList<String> msgs;

	public Canal(int tamanho) {
		this.setTamanho(tamanho);
		this.msgs = new ArrayList<>();
	}

	@Override
	public  void  putMessage(String message) {
		synchronized (this.msgs) {
			while(this.getMsgs().size() >= this.tamanho) {
				try {
					System.out.println("esperando canal cheio");
					System.out.println(this.getMsgs().size());
					this.msgs.wait();
				} catch(InterruptedException e) {}
			}

			this.msgs.add(message);
			System.out.println("Mensagem adicionada ao canal: " + message);
			this.msgs.notifyAll();
		}
	}

	@Override
	public  String takeMessage() {
		synchronized (this.msgs) {
			
		
		while(this.getMsgs().isEmpty()) {
			try {
				System.out.println("canal vazio, esperando!");
				this.msgs.wait();
			} catch(InterruptedException e) {}
		}
		
		String aux = this.getMsgs().get(0);
		this.msgs.remove(0);
		this.msgs.notifyAll();
		System.out.println( "Mensagem retirada do canal: " +aux);
		return aux;
	}
}	


	public int getTamanho() {
		return tamanho;
	}


	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}


	public ArrayList<String> getMsgs() {
		return msgs;
	}


	public void setMsgs(ArrayList<String> msgs) {
		this.msgs = msgs;
	}


	@Override
	public void run() {
		System.out.println("0");
		this.putMessage("dedo no rabo");
		this.putMessage("message");
		System.out.println(this.takeMessage());
	}
	
}
