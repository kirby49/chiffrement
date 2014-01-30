import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Authentification implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login = "client";
	public boolean authentifier = false;
	public Thread t2;
	
	public Authentification(Socket s){
		 socket = s;
		}
	public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
		while(!authentifier){
			
			out.println("Entrez votre login :");
			out.flush();
			login = in.readLine();

			if(!login.isEmpty()){
				
				out.println("Vous êtes connecté");
				System.out.println(login +" vient de se connecter ");
				out.flush();
				envoiCleServer();
				authentifier = true;	
			}
			else {out.println("erreur"); out.flush();}
		 }
			t2 = new Thread(new Chat_Server(socket,login));
			t2.start();
			
		} catch (IOException e) {
			
			System.err.println(login+" ne répond pas !");
		}
	}
	
	public void envoiCleServer() 
	{
		try {
			Scanner sc = new Scanner(new File("public_server.txt"));
			out.println(sc.nextLine());	
		} catch (FileNotFoundException e) {	
			System.err.println("Le fichier n'existe pas !");
		}
		out.flush();
	}
}