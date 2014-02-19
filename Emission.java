import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;


public class Emission implements Runnable {

	private PrintWriter out;
	private String message = "";
	private Scanner sc = null;
	private String login = "";
	private String fichier = "";
	
	public Emission(PrintWriter out, String login, String fichier) {
		this.out = out;
		this.login = login;
		this.fichier = fichier;
	}

	
	public void run() {
		
		Scanner f;
		try {
			f = new Scanner(new File(fichier));
			
			BigInteger big1 = new BigInteger(f.next());
			BigInteger big2 = new BigInteger(f.next());
			
			while(!message.equals("exit")){
				MessageAChiffrer mac= new MessageAChiffrer(big1, big2);
				sc = new Scanner(System.in);
				message = sc.nextLine();
				mac.setTexte(message);
				mac.chiffrement();
				out.println(login+" : "+mac.getTexteChiffre());
			    out.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}