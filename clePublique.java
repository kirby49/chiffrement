package chiffrement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class clePublique {

	private static BigInteger varP;
	private static BigInteger varQ;
	private static BigInteger varN;
	private static BigInteger varM;
	private static BigInteger varE;
	
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
		
		varN= varP.multiply(varQ);
		varM=varP.subtract(BigInteger.ONE).multiply(varQ.subtract(BigInteger.ONE));		
		varE=choisirE(varM);
		
		System.out.println("p: "+varP);
		System.out.println("q: "+varQ);
		System.out.println("n: "+varN);
		System.out.println("m: "+varM);
		System.out.println("e: "+varE);
		
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


	public BigInteger getVarE() {
		return varE;
	}


	

	public BigInteger getVarM() {
		return varM;
	}

	public void ecrire()
	{
		//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
		String adressedufichier = "/home/etudiant/" + "ClePrive";
	
		try
		{
			/**
			 * BufferedWriter a besoin d un FileWriter, 
			 * les 2 vont ensemble, on donne comme argument le nom du fichier
			 * true signifie qu on ajoute dans le fichier (append), on ne marque pas par dessus 
			 
			 */
			FileWriter fw = new FileWriter(adressedufichier, true);
			
			// le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
			BufferedWriter output = new BufferedWriter(fw);
			
			//on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
			output.write("varN: "+varN+"\n"+"VarE: "+varE+"\n");
			//on peut utiliser plusieurs fois methode write
			
			output.flush();
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
