package chiffrement;

import java.math.BigInteger;

abstract public class Message {
	
	protected String texte;
	protected BigInteger [] ascii;
	protected BigInteger varEorU;
	protected BigInteger varN;
	
	
	public Message(BigInteger eoru, BigInteger n){
		varEorU = eoru;
		varN= n;
		ascii=new BigInteger [100];
	}

	
	public String getTexte() {
		return texte;
	}

	public void setTexte(String te) {
		texte = te;
	}

	public BigInteger[] getAscii() {
		return ascii;
	}
	
	public void setAscii(BigInteger[] tab) {
		ascii=tab;
	}
	

	
	
}
