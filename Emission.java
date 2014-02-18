
import java.io.PrintWriter;
import java.util.Scanner;


public class Emission implements Runnable {

	private PrintWriter out;
	private String message = "";
	private Scanner sc = null;
	
	public Emission(PrintWriter out) {
		this.out = out;
	}

	
	public void run() {
		
		  sc = new Scanner(System.in);
		  
		  while(!message.equals("exit")){
				message = sc.nextLine();
				out.println(message);
			    out.flush();
		  }
	}
}