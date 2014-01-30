package chiffrement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class ClePrive {
	
	private static BigInteger varE;
	private static BigInteger varM;
	private static BigInteger varU;

	ClePrive(BigInteger a, BigInteger b){
		//varE= new BigInteger("7");
		//varM= new BigInteger("4992");	
		varE= a;
		varM=b;	
		genererClePrive();
	}
	
public static void genererClePrive(){

		BigInteger v0= BigInteger.ZERO;
		BigInteger v1=BigInteger.ONE;
		BigInteger u0= BigInteger.ONE;
		BigInteger u1=BigInteger.ZERO;
		
		varU =calcul(u0,u1,v0,v1,varE,varM);
		
		System.out.println("U a pour valeur :"+varU);
	}
	
	//fonction récursive pour calculer u;
	public static BigInteger calcul(BigInteger u0, BigInteger u1, BigInteger v0, BigInteger v1, BigInteger r0, BigInteger r1 ){
		
		BigInteger rn0=r1;
		BigInteger un0=u1;
		BigInteger vn0=v1;
		BigInteger rn1=r0.subtract(r0.divide(r1).multiply(r1));
		BigInteger un1=u0.subtract(r0.divide(r1).multiply(u1));;
		BigInteger vn1=v0.subtract(r0.divide(r1).multiply(v1));;
		/*
		System.out.println("r: "+rn0+" "+rn1);
		System.out.println("u: "+un0+" "+un1);
		System.out.println("v: "+vn0+" "+vn1);
		*/
		if (rn1.equals(BigInteger.ZERO)) 
			return un1.add(un0);
		
		else
			return calcul(un0, un1, vn0, vn1, rn0, rn1);
			
	}
	
	public static BigInteger getVarE() {
		return varE;
	}

	public static BigInteger getVarM() {
		return varM;
	}

	public static BigInteger getVarU() {
		return varU;
	}
	
	public void ecrire()
	{
		//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
		String adressedufichier = "/home/etudiant/" + "ClePublic";
	
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
			output.write("varE: "+varE+"\n"+"VarM: "+varM+"\n"+"VarU: "+varU);
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
