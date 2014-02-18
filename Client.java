import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	
	public static void main(String[] args) {
		
		
		Socket socket;
		BufferedReader in;
		PrintWriter out;

		try {
			socket = new Socket(args[0],Integer.parseInt(args[1]));
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			
			Thread t3 = new Thread(new EmissionCle(out, "./public_client.txt"));
			t3.start();
			
			Thread t4 = new Thread(new ReceptionCle(in, "./known_server.txt"));
			t4.start();
			
			
			Thread t1 = new Thread(new Emission(out));
			t1.start();
			Thread t2 = new Thread(new Reception(in));
			t2.start();
			
		    //socket.close();
		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}