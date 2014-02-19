import java.math.BigInteger;

public class MessageAChiffrer extends Message {

	public MessageAChiffrer(BigInteger n,BigInteger e) {
		super(n,e);
	}

	public void chiffrement(){
		for(int i =0 ; i<texte.length(); i++)
		{
			int a =(int)texte.charAt(i);
			BigInteger A= BigInteger.valueOf(a);
			BigInteger res= A.modPow(varEorU, varN);
			System.out.println(res);
			ascii[i]=res;
			texteChiffre+= res+" ";
		}
	}
	

}
	
	