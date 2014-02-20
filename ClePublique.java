import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;

public class ClePublique {

	private static BigInteger varP;
	private static BigInteger varQ;
	private static BigInteger varN;
	private static BigInteger varM;
	private static BigInteger varE;
	private static String name;
	
	ClePublique(String n){
		name =n;
		genererClePublic();
	}
	
	
	public static void genererClePublic(){
		//initialisation des bigIntegers p et q en mode aleatoire
		varP= BigInteger.probablePrime(1000, new Random());
		varQ= BigInteger.probablePrime(100, new Random());
		
		while(varP.equals(varQ)){
			varQ= BigInteger.probablePrime(100, new Random());
		}
		//if (varP.isProbablePrime(100)) System.out.println("la variable p est peut etre pas premier");
		//if (varQ.isProbablePrime(100)) System.out.println("la variable q est peut etre pas premier");
		
		varN= varP.multiply(varQ);
		varM=varP.subtract(BigInteger.ONE).multiply(varQ.subtract(BigInteger.ONE));
		varE=choisirE(varM);
		
		System.out.println("p: "+varP);
		System.out.println("q: "+varQ);
		System.out.println("n: "+varN);
		System.out.println("m: "+varM);
		System.out.println("e: "+varE);
		
	}

	public static  BigInteger choisirE(BigInteger m) {
		/*
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
		*/
		BigInteger resultat = new BigInteger(10,new Random());
		//boucle tant que resultat n'est pas impair et premier avec m
		while
			(
				(
						!(resultat.gcd(m).compareTo(BigInteger.ONE)==0)
				) 
				/*
				&&			
				(
						!(resultat.mod(new BigInteger("2")).compareTo(BigInteger.ONE)==0)
				) 
				*/
			)
			resultat = new BigInteger(10,new Random());
		
			return resultat;
	}


	public BigInteger getVarE() {
		return varE;
	}

	public BigInteger getVarN() {
		return varN;
	}
	

	public BigInteger getVarM() {
		return varM;
	}

	public void ecrire()
	{
		//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
		String adressedufichier = "public_"+name+".txt";
	
		try
		{
			/**
			 * BufferedWriter a besoin d un FileWriter, 
			 * les 2 vont ensemble, on donne comme argument le nom du fichier
			 * true signifie qu on ajoute dans le fichier (append), on ne marque pas par dessus 
			 
			 */
			FileWriter fw = new FileWriter(adressedufichier, false);
			
			// le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
			PrintWriter output = new PrintWriter(fw);
			
			//on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
			output.println(varN+" "+varE);
			
			//on peut utiliser plusieurs fois methode write
			
			//output.flush();
			//ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter
			
			output.close();
			//et on le ferme
			System.out.println("fichier créé");
		}
		catch(IOException ioe){
			System.out.print("Erreur : ");
			ioe.printStackTrace();
			}

	}


	
	
	
	
	

}