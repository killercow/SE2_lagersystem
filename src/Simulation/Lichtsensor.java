package Simulation;
import java.util.*;

public class Lichtsensor {

	private static int LichtsensorAdresse;
	private int LichtsensorAdresseDefault = 0; 
	public boolean isteingeschaltet = false; 

	public Lichtsensor(){
		this.LichtsensorAdresse = ErstelleAdresse(); 
	}

	private int ErstelleAdresse() {
		Random generator = new Random(); 
		int xteLichtsensorAdresse = LichtsensorAdresseDefault + generator.nextInt(255); 
		System.out.println("Lichtsensor mit der Adresse " + xteLichtsensorAdresse + " erstellt.");
		return xteLichtsensorAdresse;
	}

	public boolean einschalten(){
		return isteingeschaltet = true; 
	}
	
	public boolean ausschalten(){
		return isteingeschaltet = false; 
	}

}