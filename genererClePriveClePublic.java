package chiffrement;

public class genererClePriveClePublic {

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		String name ="default";		
		try
		{
			name = args[0];
		}
		catch(Error e){}
		clePublique clePu= new clePublique(name);
		clePu.ecrire();

		ClePrive clePrive= new ClePrive(clePu.getVarE(),clePu.getVarM(),clePu.getVarN(),name); 
		clePrive.ecrire();


	}

}
