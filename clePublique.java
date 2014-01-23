package chiffrement;
import java.math.BigInteger;
import java.util.Random;

public class clePublique {

	static BigInteger varP;
	static BigInteger varQ;
	
	clePublique(){
		genererClePublic();
	}
	
	
	public static void genererClePublic(){
		//initialisation des bigIntegers p et q en mode aleatoire
		varP= BigInteger.probablePrime(10, new Random());
		varQ= BigInteger.probablePrime(10, new Random());
		
		while(varP.equals(varQ)){
			varQ= BigInteger.probablePrime(2, new Random());
		}
		
		BigInteger n= varP.multiply(varQ);
		BigInteger m= varP.subtract(BigInteger.ONE).multiply(varQ.subtract(BigInteger.ONE));
		
		BigInteger e= choisirE(m);
		
		System.out.println("p: "+varP);
		System.out.println("q: "+varQ);
		System.out.println("n: "+n);
		System.out.println("m: "+m);
		System.out.println("e: "+e);
		
	}

	public static BigInteger choisirE(BigInteger m) {
		BigInteger resultat = new BigInteger(10,new Random());
		//boucle tant que resultat n'est pas impair et premier avec m
		while((resultat.mod(BigInteger.ONE.add(BigInteger.ONE)).equals(BigInteger.ZERO)))
		{
			if(resultat.gcd(m).equals(BigInteger.ONE)) 
				break;
			else
				resultat = new BigInteger(10,new Random());
		}
		return resultat;
	}

	
	
	
	

}
