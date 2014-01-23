package chiffrement;

import java.math.BigInteger;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger a= new BigInteger("7");
		BigInteger b= new BigInteger("4992");
		
		clePublique clePu = new clePublique();
		ClePrive clePr = new ClePrive(clePu.varP,clePu.varQ);
	}

}
