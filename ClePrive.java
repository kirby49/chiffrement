package chiffrement;

import java.math.BigInteger;

public class ClePrive {
	
	static BigInteger varE;
	static BigInteger varM;
	static BigInteger varU;

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
	
}
