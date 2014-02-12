import java.io.BufferedReader;
import java.io.IOException;


public class Reception implements Runnable {

	private BufferedReader in;
	private String message = "";
	
	public Reception(BufferedReader in){
		
		this.in = in;
	}
	
	public void run() {
		
		while(!message.equals("exit")){
	        try {
	        	
			message = in.readLine();
			System.out.println(message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}