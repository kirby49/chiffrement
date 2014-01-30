import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Emission_Server implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;
	
	public Emission_Server(PrintWriter out) {
		this.out = out;
	}

	
	public void run() {
		
		  sc = new Scanner(System.in);
		  
		  while(true){
				message = sc.nextLine();
				out.println(message);
			    out.flush();
			  }
	}
}