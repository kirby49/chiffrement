import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;


public class Reception implements Runnable {

	private BufferedReader in;
	private String message = "";
	private String fichier;
	
	public Reception(BufferedReader in, String fichier){
		this.fichier = fichier;
		this.in = in;
	}
	
	public void run() {
		
		Scanner f;
		try {
			f = new Scanner(new File(fichier));
		
			BigInteger big1 = new BigInteger(f.next());
			BigInteger big2 = new BigInteger(f.next());
		
				while(!message.equals("exit")){
	        	
					MessageADechiffrer mad = new MessageADechiffrer(big1,big2);
					message = in.readLine();
					System.out.println(message);
					String[] tokens = message.split(" : ");
					mad.setTexteChiffre(tokens[1]);
					mad.dechiffrement2();
					System.out.println(tokens[0]+" : "+mad.getTexte());
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
}
