package chiffrement;

import java.math.BigInteger;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		BigInteger e= new BigInteger("7");
		BigInteger n= new BigInteger("5141");
		BigInteger m= new BigInteger("4992");
		BigInteger u= new BigInteger("4279");
		*/
		String name =args[0];
		//cle publique de bob
		clePublique clePu= new clePublique(name);
		clePu.ecrire();
		//clepublique d'alice
		//clePublique clePu2= new clePublique();
		//cle prive de bobo
		ClePrive clePrive= new ClePrive(clePu.getVarE(),clePu.getVarM(),clePu.getVarN(),name); 
		//ClePrive clePrive= new ClePrive(e,m,n); 
		//alice envoi un message avec clé publique de Bob
		messageAChiffrer test= new messageAChiffrer(clePu.getVarN(),clePu.getVarE()); 
		//messageAChiffrer test= new messageAChiffrer(n,e);
		//bob dechiffre avec sa clé privé
		messageADechiffrer test2 = new messageADechiffrer(clePrive.getVarN(),clePrive.getVarU());

		test.setTexte("mon test de la clé");
		test.chiffrement();
		test2.setAscii(test.getAscii());
		test2.dechiffrement();
		System.out.println(test2.getTexte());

		/*
		clePublique clePu = new clePublique();
		clePu.ecrire();
		//ClePrive clePr = new ClePrive(e,clePu.getVarM(),n);
		ClePrive clePr = new ClePrive(clePu.getVarE(),clePu.getVarM(),clePu.getVarN());
		clePr.ecrire();
		*/
		/*
		Scanner sc = new Scanner(System.in);
		messageAChiffrer test= new messageAChiffrer(clePu.getVarN(),clePu.getVarE()); 
		messageADechiffrer test2 = new messageADechiffrer(clePr.getVarN(),clePr.getVarU());
		//messageAChiffrer test= new messageAChiffrer(n,e); 
		//messageADechiffrer test2 = new messageADechiffrer(n,u); 
		String mess= sc.nextLine();
		test.setTexte(mess);
		test.chiffrement();
		BigInteger [] tab = {new BigInteger("386") , new BigInteger("737") , new BigInteger("970"), new BigInteger("204"), new BigInteger("1858")};
		test2.setAscii(tab);
		//test2.setAscii(test.getAscii());
		test2.dechiffrement();
		System.out.println(test2.getTexte());
		
		
		
		
		//String test2 =test.texte;
		
		
		
		sc.close();
		*/
	}

}
