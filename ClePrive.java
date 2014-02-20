import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class ClePrive {
	
	private static BigInteger varE;
	private static BigInteger varM;
	private static BigInteger varU;
	private static BigInteger varN;
	private static String name;

	ClePrive(BigInteger a, BigInteger b,BigInteger c, String n){	
		name=n;
		varE=a;
		varM=b;	
		varN=c;
		genererClePrive();
	}
	
public static void genererClePrive(){

		BigInteger v0= BigInteger.ZERO;
		BigInteger v1=BigInteger.ONE;
		BigInteger u0= BigInteger.ONE;
		BigInteger u1=BigInteger.ZERO;
		
		varU =calcul(varE,varM, u0,u1,v0,v1);
		
	}
	
	//fonction récursive pour calculer u;
	public static BigInteger calcul(BigInteger r0, BigInteger r1,BigInteger u0, BigInteger u1, BigInteger v0, BigInteger v1 ){
		
		BigInteger rn0=r0;
		BigInteger un0=u0;
		BigInteger vn0=v0;
		BigInteger rn1=r1;
		BigInteger un1=u1;
		BigInteger vn1=v1;
		
		if (rn1.equals(BigInteger.ZERO)) 
		{
			System.out.println("r: "+rn0+" "+rn1+" ");
			System.out.println("u: "+un0+" "+un1+" ");
			System.out.println("v: "+vn0+" "+vn1+" ");
			if((new BigInteger("2").compareTo(un0)==-1))
			{
				System.out.println("boucle un");
				return un0;
			}
			else
			{
				BigInteger k = new BigInteger("-1");
				BigInteger res= un0.subtract(k.multiply(varM));
				while(!(new BigInteger("2").compareTo(res)==-1))			
				{
					k.subtract(BigInteger.ONE);
					res= un0.subtract(k.multiply(varM));
				}
				System.out.println("un0: "+un0+" k: "+k+" m: "+varM);
				return res;
			}				
		}
	
		else
		{
			BigInteger rn2=r0.subtract(r0.divide(r1).multiply(r1));
			BigInteger un2=u0.subtract(r0.divide(r1).multiply(u1));
			BigInteger vn2=v0.subtract(r0.divide(r1).multiply(v1));
			return calcul(rn1, rn2,un1, un2, vn1, vn2);
		}	
		
	}
	
	public static BigInteger getVarE() {
		return varE;
	}

	public static BigInteger getVarM() {
		return varM;
	}

	public BigInteger getVarU() {
		return varU;
	}
	
	public BigInteger getVarN() {
		return varN;
	}
	
	public void ecrire()
	{
		//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
		String adressedufichier = "private_"+name+".txt";
	
		try
		{
			/**
			 * BufferedWriter a besoin d un FileWriter, 
			 * les 2 vont ensemble, on donne comme argument le nom du fichier
			 * true signifie qu on ajoute dans le fichier (append), on ne marque pas par dessus 
			 
			 */
			FileWriter fw = new FileWriter(adressedufichier, false);
			
			// le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
			BufferedWriter output = new BufferedWriter(fw);
			
			//on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
			//output.write("varE: "+varE+"\n"+"VarM: "+varM+"\n"+"VarU: "+varU);
			output.write(varN+" "+varU);
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