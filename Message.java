import java.math.BigInteger;

abstract public class Message {
	
	protected String texte;
	protected BigInteger [] ascii;
	protected BigInteger varEorU;
	protected BigInteger varN;
	protected String texteChiffre;
	
	
	public String getTexteChiffre() {
		return texteChiffre;
	}


	public void setTexteChiffre(String texteChiffre) {
		this.texteChiffre = texteChiffre;
	}


	public Message(BigInteger n,BigInteger eoru){
		varEorU = eoru;
		varN= n;
		texteChiffre="";
	}

	
	public String getTexte() {
		if(texte.isEmpty())
			{
				System.out.println("le texte n'est pas initialisé correctement");
				return null;
			}
		else
			return texte;
	}

	public void setTexte(String te) {
		texte = te;
		ascii= new BigInteger[texte.length()];
	}

	public BigInteger[] getAscii() {
		if(ascii.length==0)
		{
			System.out.println("le tableau n'est pas initialisé correctement");
			return null;
		}
		else
			return ascii;
	}
	
	public void setAscii(BigInteger[] tab) {
		ascii=tab;
	}
	

	
	
}