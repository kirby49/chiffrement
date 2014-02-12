import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server { 
	
	public static void main(String[] args) {
		
		ServerSocket socketserver  ;
		Socket socket ;
		BufferedReader in;
		PrintWriter out;
		
		try {
		
			socketserver = new ServerSocket(Integer.parseInt(args[0]));
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
			socket = socketserver.accept();
			
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			
			Thread t3 = new Thread(new EmissionCle(out, "./public_server.txt"));
			t3.start();
			
			Thread t4 = new Thread(new ReceptionCle(in, "./known_client.txt"));
			t4.start();
			
			Thread t1 = new Thread(new Emission(out));
			t1.start();
			Thread t2 = new Thread(new Reception(in));
			t2.start();
			
		    //socket.close();
		    //socketserver.close();
		        
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}