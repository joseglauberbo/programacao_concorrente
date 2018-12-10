package a;

import java.text.NumberFormat;

public class Java {

	public static void main(String[] args) {

		new Thread(t1).start();


	}

	private static Runnable t1 = new Runnable() {
		public void run() {
			try {
				Runtime runtime = Runtime.getRuntime();

				NumberFormat format = NumberFormat.getInstance();

				StringBuilder sb = new StringBuilder();
				long allocatedMemory = runtime.totalMemory();

				sb.append("allocated memory: " + format.format(allocatedMemory / 1024/1024) + "<br/>");

				System.out.println(sb);
			} catch (Exception e) {
			}

		}
	};

}
