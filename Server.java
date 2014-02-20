import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
		String login;
		String name ="server";
		
		System.out.println("===========Clé Publique==========");
		
		ClePublique clePu= new ClePublique(name);
		clePu.ecrire();

		System.out.println("============Clé Privée===========");
		
		ClePrive clePrive= new ClePrive(clePu.getVarE(),clePu.getVarM(),clePu.getVarN(),name); 
		clePrive.ecrire();
		
		Scanner nom = new Scanner(System.in);
		
		System.out.println("Quel est votre nom ?");
		
		login = nom.nextLine();
		
		try {
			
			socketserver = new ServerSocket(Integer.parseInt(args[0]));
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
			socket = socketserver.accept();
			
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			
			try {
				Scanner sc = new Scanner(new File("public_server.txt"));
				out.println(sc.nextLine());	
			} catch (FileNotFoundException e) {	
				System.err.println("Le fichier n'existe pas !");
			}
			out.flush();
			
			String cle = "";
			FileWriter fw;
			try {
				fw = new FileWriter("known_client.txt", false);
				BufferedWriter output = new BufferedWriter(fw);
				cle = in.readLine();
				output.write(cle);
				output.flush();
				output.close();
			} catch (IOException e) {	
				e.printStackTrace();
			}
			
			Thread t1 = new Thread(new Emission(out, login, "known_client.txt"));
			t1.start();
			
			Thread t2 = new Thread(new Reception(in, "private_server.txt"));
			t2.start();
		        
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}