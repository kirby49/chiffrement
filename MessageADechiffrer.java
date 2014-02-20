import java.math.BigInteger;

public class MessageADechiffrer extends Message {

	public MessageADechiffrer( BigInteger n,BigInteger u) {
		super(n,u);
	}
	
	public void dechiffrement(){
		char[] tab = new char[ascii.length];
		for(int i =0 ; i<ascii.length; i++){
			BigInteger A= ascii[i];
			BigInteger res= A.modPow(varEorU, varN);
			int a = res.intValue();
			tab[i]=(char)a;
		}
		String resultat= new String(tab);
		texte= resultat;
	}
	
	public void dechiffrement2(){
		String[] res=texteChiffre.split(" ");
		BigInteger[] test= new BigInteger[res.length];
		for (int i= 0 ; i < res.length; i++){
			test[i]= new BigInteger(res[i]);
		}
		this.setAscii(test);
		char[] tab = new char[ascii.length];
		for(int i =0 ; i<ascii.length; i++){
			BigInteger A= ascii[i];
			BigInteger res2= A.modPow(varEorU, varN);
			int a = res2.intValue();
			tab[i]=(char)a;
		}
		String resultat= new String(tab);
		texte= resultat;

	}

}