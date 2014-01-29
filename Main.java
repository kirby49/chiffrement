package chiffrement;

import java.math.BigInteger;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger e= new BigInteger("7");
		BigInteger n= new BigInteger("5141");
		BigInteger u= new BigInteger("4279");
		
		clePublique clePu = new clePublique();
		ClePrive clePr = new ClePrive(clePu.getVarE(),clePu.getVarM());
		
		
		Scanner sc = new Scanner(System.in);
		messageAChiffrer test= new messageAChiffrer(e,n); 
		messageADechiffrer test2 = new messageADechiffrer(u,n); 
		String mess= sc.nextLine();
		test.setTexte(mess);
		test.chiffrement();
		BigInteger [] tab = {new BigInteger("386") , new BigInteger("737") , new BigInteger("970"), new BigInteger("204"), new BigInteger("1858")};
		test2.setAscii(tab);
		test2.dechiffrement();
		System.out.println(test2.getTexte());
		
		
		
		//String test2 =test.texte;
		
		
		
		sc.close();
		
	}

}
