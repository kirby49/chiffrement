
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class EmissionCle implements Runnable {

	private PrintWriter out;
	private String fichier = "";
	
	public EmissionCle(PrintWriter out, String name) {
		this.out = out;
		this.fichier = name;
	}

	
	public void run() {
		
		try {
			Scanner sc = new Scanner(new File(fichier));
			out.println(sc.nextLine());	
		} catch (FileNotFoundException e) {	
			System.err.println("Le fichier n'existe pas !");
		}
		out.flush();
	}
}

