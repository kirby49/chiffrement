package chiffrement;

import java.math.BigInteger;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String name ="default";

		clePublique clePu= new clePublique(name);
		ClePrive clePrive= new ClePrive(clePu.getVarE(),clePu.getVarM(),clePu.getVarN(),name); 

		messageAChiffrer test= new messageAChiffrer(clePu.getVarN(),clePu.getVarE()); 

		messageADechiffrer test2 = new messageADechiffrer(clePrive.getVarN(),clePrive.getVarU());

		test.setTexte("mon test de la clé");
		test.chiffrement();

		test2.setTexteChiffre(test.getTexteChiffre());
		test2.dechiffrement2();
		System.out.println(test2.getTexte());

		
	}

}
