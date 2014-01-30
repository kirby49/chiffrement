import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Connexion implements Runnable {

	private Socket socket = null;
	public static Thread t2;
	public static String login = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private Scanner sc = null;
	private boolean connect = false;
	
	public Connexion(Socket s){
		
		socket = s;
	}
	
	public void run() {
		
		try {
			
		out = new PrintWriter(socket.getOutputStream());
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
	
		
		while(!connect ){
		
		System.out.println(in.readLine());
		login = sc.nextLine();
		out.println(login);
		out.flush();
		
		if(in.readLine().equals("Vous êtes connecté")){
		connect = true;
		envoiCleClient();
		  }
		
		else {
			System.err.println("Vos informations sont incorrectes "); 
		  }
		
	}
			
			t2 = new Thread(new Chat_ClientServer(socket));
			t2.start();
		
		} catch (IOException e) {
			
			System.err.println("Le serveur ne répond plus ");
		}
	}

	public void envoiCleClient()
	{
		try {
			Scanner sc = new Scanner(new File("public_client.txt"));
			out.println(sc.nextLine());	
		} catch (FileNotFoundException e) {	
			System.err.println("Le fichier n'existe pas !");
		}
		out.flush();
	}
	
}