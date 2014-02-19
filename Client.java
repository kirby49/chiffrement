import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	
	public static void main(String[] args) {
		
		
		Socket socket;
		BufferedReader in;
		PrintWriter out;
		String login;
		String name ="client";
		
		
		ClePublique clePu= new ClePublique(name);
		clePu.ecrire();

		ClePrive clePrive= new ClePrive(clePu.getVarE(),clePu.getVarM(),clePu.getVarN(),name); 
		clePrive.ecrire();

		Scanner nom = new Scanner(System.in);
		
		System.out.println("Quel est votre nom ?");
		
		login = nom.nextLine();
		
		try {
			
			socket = new Socket(args[0],Integer.parseInt(args[1]));
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			
			String cle = "";
			FileWriter fw;
			try {
				fw = new FileWriter("known_server.txt", false);
				BufferedWriter output = new BufferedWriter(fw);
				cle = in.readLine();
				output.write(cle);
				output.flush();
				output.close();
			} catch (IOException e) {	
				e.printStackTrace();
			}	
			
			try {
				Scanner sc = new Scanner(new File(/*fichier*/"public_client.txt"));
				out.println(sc.nextLine());	
			} catch (FileNotFoundException e) {	
				System.err.println("Le fichier n'existe pas !");
			}
			out.flush();
			
			Thread t1 = new Thread(new Emission(out, login, "known_server.txt"));
			t1.start();
			Thread t2 = new Thread(new Reception(in, "private_client.txt"));
			t2.start();
			
		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}