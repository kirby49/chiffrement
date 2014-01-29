package chiffrement;

import java.math.BigInteger;

public class messageADechiffrer extends Message {

	public messageADechiffrer(BigInteger e, BigInteger n) {
		super(e, n);
		// TODO Auto-generated constructor stub
	}
	
	public void dechiffrement(){
		char[] tab = new char[100];
		for(int i =0 ; i<ascii.length; i++){
			//int a =(int)texte.charAt(i);
			BigInteger A= ascii[i];
			BigInteger res= A.modPow(varEorU, varN);
			int a = res.intValue();
			tab[i]=(char)a;
		}
		String resultat= new String(tab);
		texte= resultat;
	}

}
