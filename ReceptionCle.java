import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class ReceptionCle implements Runnable {

	private BufferedReader in;
	private String fichier = "";
	
	public ReceptionCle(BufferedReader in, String name){
		this.fichier = name;
		this.in = in;
	}
	
	public void run() {
		
		String cle = "";
		FileWriter fw;
		try {
			fw = new FileWriter(fichier, false);
			BufferedWriter output = new BufferedWriter(fw);
			cle = in.readLine();
			output.write(cle);
			output.flush();
			output.close();
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}

}