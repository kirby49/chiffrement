package chiffrement;
import java.math.BigInteger;

public class messageAChiffrer extends Message {

	public messageAChiffrer(BigInteger e, BigInteger n) {
		super(e, n);
		// TODO Auto-generated constructor stub
	}

	public void chiffrement(){

		for(int i =0 ; i<texte.length(); i++){
			int a =(int)texte.charAt(i);
			BigInteger A= BigInteger.valueOf(a);
			BigInteger res= A.modPow(varEorU, varN);
			System.out.println(res);
			ascii[i]=res;
		//System.out.println(ascii[i]);	
		}
	}
}
	
	
