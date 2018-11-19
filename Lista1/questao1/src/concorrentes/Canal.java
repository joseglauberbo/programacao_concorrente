package concorrentes;

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
		synchronized (message) {
			while(this.getMsgs().size() >= this.tamanho) {
				try {
					System.out.println("esperando canal cheio");
					System.out.println(this.getMsgs().size());
					message.wait();
				} catch(InterruptedException e) {}
			}

			this.msgs.add(message);
			System.out.println("Add ao canal na posicao" + this.getMsgs().size() + this.msgs);
			message.notifyAll();
		}
	}

	@Override
	public  synchronized String takeMessage() {

		while(this.getMsgs().isEmpty()) {
			try {
				System.out.println("canal vazio, esperando!");
				this.wait();
			} catch(InterruptedException e) {}
		}
		
		String aux = this.getMsgs().get(0);
		this.msgs.remove(0);
		this.notifyAll();
		System.out.println(aux + this.msgs);
		return aux;
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
